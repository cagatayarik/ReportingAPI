//package com.example.reporting_api.config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class JwtTokenFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        String authorizationHeader = request.getHeader("Authorization");
//
//        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7); // "Bearer " kısmını atla
//            if (validateToken(token)) {
//                // Token geçerliyse, kullanıcıyı kimlik doğrulama bağlamına ekleyin
//                // Örnek: SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private boolean validateToken(String token) {
//        // Token doğrulama işlemleri burada yapılır
//        // Örnek: JWT token doğrulama
//        return true;
//    }
//}
