package cgg.smartcontactmanager.smartcontactmanager.config;

import cgg.smartcontactmanager.smartcontactmanager.entities.CustomUserDetails;
import cgg.smartcontactmanager.smartcontactmanager.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfig {

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Bean
  SecurityFilterChain getSecurityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .csrf(c -> c.disable())
      .authorizeHttpRequests(a ->
        a
          .requestMatchers("/admin/**")
          .hasRole("ADMIN")
          .requestMatchers("/user/**")
          .hasRole("USER")
          .requestMatchers("/**")
          .permitAll()
      )
      .formLogin(login ->
        login
          .loginPage("/signin")
          .loginProcessingUrl("/dologin")
          .defaultSuccessUrl("/user/index")
      // .failureUrl("/login-fail")
      )
      .logout(logout ->
        logout.logoutUrl("/logout").logoutSuccessUrl("/signin?logout")
      );
    return http.build();
  }

  @Bean
  UserDetailsService getUserDetailsService() {
    // UserDetails userDetails = User
    //   .withUsername("sakshath")
    //   .password(getPasswordEncoder().encode("sakshath"))
    //   .roles("USER")
    //   .build();
    // return new InMemoryUserDetailsManager(userDetails);
    return customUserDetailsService;
  }

  @Bean
  AuthenticationProvider getAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(customUserDetailsService);
    provider.setPasswordEncoder(getPasswordEncoder());
    return provider;
  }

  @Bean
  BCryptPasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
