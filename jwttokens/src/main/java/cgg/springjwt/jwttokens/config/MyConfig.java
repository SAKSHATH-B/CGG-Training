package cgg.springjwt.jwttokens.config;

import cgg.springjwt.jwttokens.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyConfig {

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  // @Bean
  // UserDetailsService getUserDetailsService() {
  //   UserDetails userDetails = User
  //     .builder()
  //     .username("sakshath")
  //     .password(getPasswordEncoder().encode("sakshath"))
  //     .roles("ADMIN")
  //     .build();
  //   return new InMemoryUserDetailsManager(userDetails);
  // }

  @Bean
  PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager getAuthenticationManager(
    AuthenticationConfiguration builder
  ) throws Exception {
    return builder.getAuthenticationManager();
  }

  @Bean
  AuthenticationProvider getAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(customUserDetailsService);
    provider.setPasswordEncoder(getPasswordEncoder());
    return provider;
  }
}
