package com.nisum.test.nisum.auth.filter;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authManager) {
//        this.authManager = authManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//
//        String username = obtainUsername(request);
//        String password = obtainPassword(request);
//
//        if(username == null) {
//            username = "";
//        }
//
//        if(password == null) {
//            password = "";
//        }
//
//        username = username.trim();
//
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//
//        return authManager.authenticate(authToken);
//    }
//}
