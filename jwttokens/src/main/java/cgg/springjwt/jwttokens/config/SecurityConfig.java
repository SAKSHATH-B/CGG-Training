package cgg.springjwt.jwttokens.config;

import cgg.springjwt.jwttokens.helper.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  private AuthenticationEntryPoint point;

  @Autowired
  private JwtAuthenticationFilter filter;

  @Bean
  SecurityFilterChain getSecurityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .cors(cors -> cors.disable())
      .authorizeHttpRequests(a ->
        a
          .requestMatchers("/test")
          //   .hasRole("ADMIN")
          //   .anyRequest()
          .authenticated()
          .requestMatchers("/auth/create")
          .permitAll()
          .requestMatchers("/auth/login")
          .permitAll()
          .requestMatchers("/auth/refresh")
          .permitAll()
          .anyRequest()
          .authenticated()
      )
      .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
      .sessionManagement(s ->
        s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      );
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
