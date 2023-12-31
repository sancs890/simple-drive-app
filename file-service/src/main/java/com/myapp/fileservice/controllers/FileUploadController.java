package com.myapp.fileservice.controllers;

import com.myapp.fileservice.dto.FileUploadResponse;
import com.myapp.fileservice.dto.FolderResponse;
import com.myapp.fileservice.models.File;
import com.myapp.fileservice.multitenancy.TenantContextHolder;
import com.myapp.fileservice.security.services.UserDetailsImpl;
import com.myapp.fileservice.services.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/user/{userId}")
public class FileUploadController {

  @Autowired
  private FileService uploadService;

  @GetMapping("/files")
  public List<FileUploadResponse> getUserFiles(HttpServletRequest request, @PathVariable("userId") Long userId)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    List<File> files = uploadService.getUserFiles(userId);
    List<FileUploadResponse> uploadResponses = new ArrayList<>();
    for (File file : files) {
      String downloadUrl = "";
      if (!file.isFolder()) {
        downloadUrl = ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("api/user/" + userId + "/files/")
            .path(String.valueOf(file.getId()))
            .toUriString();
      } else {
        downloadUrl = ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("api/user/" + userId + "/folder/")
            .path(String.valueOf(file.getId()))
            .toUriString();
      }
      Long size = Objects.isNull(file.getData()) ? 0 : Long.valueOf(file.getData().length);
      uploadResponses.add(new FileUploadResponse(file.getId(), file.getFileName(), downloadUrl,
                                                 file.getFileType(),
                                                 size));
    }
    return uploadResponses;
  }

  @PostMapping("/files")
  public FileUploadResponse uploadFile(HttpServletRequest request, @PathVariable("userId") Long userId,
                                       @RequestParam("file") MultipartFile file)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    File attachment = null;
    String downloadUrl = "";
    attachment = uploadService.saveFile(file, userId);
    downloadUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("api/user/" + userId + "/files/")
        .path(String.valueOf(attachment.getId()))
        .toUriString();
    return new FileUploadResponse(attachment.getId(), attachment.getFileName(), downloadUrl,
                                  file.getContentType(),
                                  file.getSize());

  }

  @GetMapping("/files/{fileId}")
  public ResponseEntity<Resource> download(HttpServletRequest request, @PathVariable("userId") Long userId,
                                           @PathVariable("fileId") Long fileId)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    File fileUpload = null;
    fileUpload = uploadService.downloadFile(fileId);
    return ResponseEntity.ok()
                         .contentType(MediaType.parseMediaType(fileUpload.getFileType()))
                         .header(HttpHeaders.CONTENT_DISPOSITION,
                                 "fileUpload; filename=\"" + fileUpload.getFileName()
                                     + "\"")
                         .body(new ByteArrayResource(fileUpload.getData()));
  }

  @PutMapping("/files/{fileId}")
  public FileUploadResponse moveFile(HttpServletRequest request,
                                     @PathVariable("fileId") Long fileId,
                                     @PathVariable("userId") Long userId,
                                     @RequestBody File file)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    File fileUpload = uploadService.updateFolder(fileId, file);
    String downloadUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("api/user/" + userId + "/files/")
        .path(String.valueOf(fileUpload.getId()))
        .toUriString();
    return new FileUploadResponse(fileUpload.getId(), fileUpload.getFileName(), downloadUrl,
                                  fileUpload.getFileType(),
                                  Long.valueOf(fileUpload.getData().length));
  }

  @PostMapping("/folder")
  public FileUploadResponse createFolder(HttpServletRequest request, @PathVariable("userId") Long userId,
                                         @RequestBody File file)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    File attachment = uploadService.saveFile(file, userId);
    String downloadUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("api/user/" + userId + "/folder/")
        .path(String.valueOf(attachment.getId()))
        .toUriString();
    return new FileUploadResponse(attachment.getId(), attachment.getFileName(), downloadUrl,
                                  attachment.getFileType(),
                                  0l);

  }

  @PostMapping("/folder/{folderId}/files")
  public FileUploadResponse uploadFileToFolder(HttpServletRequest request, @PathVariable("userId") Long userId,
                                               @PathVariable("folderId") Long folderId,
                                               @RequestParam("file") MultipartFile file)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    File attachment = uploadService.saveFile(file, userId, folderId);
    String downloadUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("api/user/" + userId + "/files/")
        .path(String.valueOf(attachment.getId()))
        .toUriString();
    return new FileUploadResponse(attachment.getId(), attachment.getFileName(), downloadUrl,
                                  file.getContentType(),
                                  file.getSize());

  }

  @GetMapping("/folder/{folderId}")
  public FolderResponse getFilesOfFolder(HttpServletRequest request, @PathVariable("userId") Long userId,
                                         @PathVariable("folderId") Long folderId)
      throws Exception {
    TenantContextHolder.setTenantId(obtainTenantFromSubdomain(request));
    userIdCheck(userId);
    String downloadUrl = "";
    List<File> files = uploadService.getFolderFiles(userId, folderId);
    List<FileUploadResponse> uploadResponses = new ArrayList<>();
    for (File file : files) {
      downloadUrl = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("api/user/" + userId + "/files/")
          .path(String.valueOf(file.getId()))
          .toUriString();
      uploadResponses.add(new FileUploadResponse(file.getId(), file.getFileName(), downloadUrl,
                                                 file.getFileType(),
                                                 Long.valueOf(file.getData().length)));
    }

    return new FolderResponse(uploadResponses);

  }

  private String obtainTenantFromSubdomain(HttpServletRequest request) {
    return request.getServerName().split("\\.")[0];
  }

  private void userIdCheck(Long pathUserId) throws Exception {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    if (userPrincipal.getId() != pathUserId) {
      throw new Exception(String.format("The user Id mismatch from logged in %d and path param %d",
                                        userPrincipal.getId()
          , pathUserId));
    }
  }

}
