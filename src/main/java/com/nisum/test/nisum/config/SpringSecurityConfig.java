package com.nisum.test.nisum.config;

//import com.nisum.test.nisum.auth.filter.JWTAuthenticationFilter;
//import com.nisum.test.nisum.auth.filter.JpaUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    @Autowired
//    private JpaUserDetails userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//            .csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//    }
//}
