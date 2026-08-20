package org.example.jwtfetch.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.jwtfetch.config.AuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(AuthProperties.class)
public class JwtFilter extends OncePerRequestFilter {
    private final AuthProperties p;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JwtFilter.doFilterInternal");
        try {
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(null);
        } catch (Exception e) {
            e.printStackTrace();
            SecurityContextHolder.clearContext();
        }
        // 무조건 실행이 되어야함
        filterChain.doFilter(request, response);
    }
}