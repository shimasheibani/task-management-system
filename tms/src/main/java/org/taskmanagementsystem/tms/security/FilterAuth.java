//package org.taskmanagementsystem.tms.security;
//
//import ch.qos.logback.core.util.StringUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class FilterAuth extends OncePerRequestFilter {
//    private final JwtUtilis jwtUtilis;
//    private final CustomUserDetailsService customUserDetailsService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token  = getTokenFromRequest(request);
//        if(token != null){
//            String email = jwtUtilis.getUsernameFromToken(token);
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
//            if (StringUtils.hasText(email) && jwtUtilis.isTokenValid(token, userDetails))
//        }
//    }
//
//    public String getTokenFromRequest(HttpServletRequest request){
//        String tokenHeader = request.getHeader("Authorization");
//        if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
//            return tokenHeader.substring(7);
//        }
//        return null;
//
//    }
//
//}
