package cgg.blogapp.blogapp.config;

import cgg.blogapp.blogapp.security.JwtAuthenticationFilter;
import cgg.blogapp.blogapp.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  private JwtAuthenticationEntryPoint entryPoint;

  @Autowired
  private JwtAuthenticationFilter filter;

  @Autowired
  private CustomUserDetailsService service;

  public static final String[] PUBLIC_URLS = {
    "/api/v1/auth/**",
    "/v3/api-docs",
    "/swagger-ui/**",
  };

  @Bean
  SecurityFilterChain getSecurityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(a ->
        a
          .requestMatchers("/admin/**")
          .hasRole("ADMIN")
          .requestMatchers(PUBLIC_URLS)
          .permitAll()
          .requestMatchers("/api/v1/**")
          .hasRole("USER")
          .requestMatchers(HttpMethod.GET)
          .permitAll()
          .anyRequest()
          .authenticated()
      )
      .authenticationProvider(getAuthenticationProvider())
      .exceptionHandling(e -> e.authenticationEntryPoint(entryPoint))
      .sessionManagement(s ->
        s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      );
    // .formLogin(login ->
    //   login
    //     .loginPage("/signin")
    //     .loginProcessingUrl("/dologin")
    //     .defaultSuccessUrl("/api/v1/posts/")
    // )
    // .logout(logout ->
    //   logout.logoutUrl("/logout").logoutSuccessUrl("/signin?logout")
    // )
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  UserDetailsService getUserDetailsService() {
    return service;
  }

  @Bean
  BCryptPasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationProvider getAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(service);
    provider.setPasswordEncoder(getPasswordEncoder());
    return provider;
  }

  @Bean
  AuthenticationManager getAuthenticationManager(
    AuthenticationConfiguration config
  ) throws Exception {
    return config.getAuthenticationManager();
  }
}
