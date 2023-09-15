package com.myapp.fileservice.security.jwt;

import com.myapp.fileservice.client.TenantServiceClient;
import com.myapp.fileservice.multitenancy.MultiTenancyJpaConfiguration;
import com.myapp.fileservice.multitenancy.TenantContextHolder;
import com.myapp.fileservice.security.services.UserDetailsServiceImpl;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthTokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Autowired
  private Map<String, DataSource> dataSourcesMtApp;

  @Autowired
  TenantServiceClient client;

  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String tenant = this.obtainTenantFromSubdomain(request);
      if (!this.dataSourcesMtApp.containsKey(tenant)) {
        List<com.myapp.tenant.shared.DataSource> dataSourceList = this.client.getAllTenants();
        boolean flag = true;
        for (com.myapp.tenant.shared.DataSource d : dataSourceList) {
          if (d.getTenantId().equalsIgnoreCase(tenant)) {
            DataSourceBuilder<?> factory = DataSourceBuilder.create(MultiTenancyJpaConfiguration.class.getClassLoader())
                                                            .url(d.getUrl())
                                                            .username(d.getUsername())
                                                            .password(d.getPassword())
                                                            .driverClassName(d.getDriverClassName());
            HikariDataSource ds = (HikariDataSource) factory.build();
            ds.setKeepaliveTime(40000);
            ds.setMinimumIdle(1);
            ds.setMaxLifetime(45000);
            ds.setIdleTimeout(35000);
            this.dataSourcesMtApp.put(tenant, ds);
            flag = false;
            break;
          }
        }
      }
      TenantContextHolder.setTenantId(tenant);
      String jwt = this.parseJwt(request);
      if (jwt != null && this.jwtUtils.validateJwtToken(jwt)) {
        String username = this.jwtUtils.getUserNameFromJwtToken(jwt);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception e) {
      logger.error("Cannot set user authentication: {}", e.getMessage());
    }

    filterChain.doFilter(request, response);
  }

  private String parseJwt(HttpServletRequest request) {
    String headerAuth = request.getHeader("Authorization");

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      return headerAuth.substring(7);
    }

    return null;
  }

  private String obtainTenantFromSubdomain(HttpServletRequest request) {
    return request.getServerName().split("\\.")[0];
  }

}
