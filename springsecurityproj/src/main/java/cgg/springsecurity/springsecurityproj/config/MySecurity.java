package cgg.springsecurity.springsecurityproj.config;

import cgg.springsecurity.springsecurityproj.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurity {

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //accessing all urls with any request authenticated
    //using httpBasic
    // http
    //   .authorizeHttpRequests(a -> a.anyRequest().authenticated())
    //   .httpBasic(withDefaults());

    //using form login
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(a ->
        a
          .requestMatchers("/signin")
          .permitAll()
          .requestMatchers("/users/**")
          .hasRole("ADMIN")
          .anyRequest()
          .authenticated()
      )
      .formLogin(login ->
        login
          .loginPage("/signin")
          .loginProcessingUrl("/dologin")
          .defaultSuccessUrl("/users/")
      )
      .logout(logout ->
        logout.logoutUrl("/logout1").logoutSuccessUrl("/signin?logout")
      );

    //protecting only some urls
    // http
    //   .authorizeHttpRequests(a ->
    //     a.requestMatchers("/public/**").permitAll().anyRequest().authenticated()
    //   )
    //   .httpBasic(withDefaults());

    //role based authentication
    // http
    //   .authorizeHttpRequests(a ->
    //     a
    //       .requestMatchers("/public/**")
    //       .hasRole("NORMAL")
    //       .anyRequest()
    //       .authenticated()
    //   )
    //   .httpBasic(withDefaults());
    // http
    //   .authorizeHttpRequests(a ->
    //     a
    //       .requestMatchers("/public/**")
    //       .hasRole("NORMAL")
    //       .requestMatchers("/users/**")
    //       .hasRole("ADMIN")
    //       .anyRequest()
    //       .authenticated()
    //   )
    //   .httpBasic(withDefaults());

    //using csrf token which enables post methods also
    // CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();

    // http
    //   // .csrf(csrf -> csrf.disable())
    //   .csrf(csrf ->
    //     csrf
    //       .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
    //       .csrfTokenRequestHandler(requestHandler)
    //   )
    //   .authorizeHttpRequests(authorizeRequests ->
    //     authorizeRequests
    //       // .requestMatchers("/public/**")
    //       // .hasRole("NORMAL")
    //       // .requestMatchers("/users/**")
    //       // .hasRole("ADMIN")
    //       .anyRequest()
    //       .authenticated()
    //   )
    //   .httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  UserDetailsService userDetailsService() {
    // UserDetails normalUser = User
    //   .withUsername("sakshath")
    //   .password(getPasswordEncoder().encode("sakshath"))
    //   .roles("NORMAL")
    //   .build();
    // UserDetails adminUser = User
    //   .withUsername("admin")
    //   .password(getPasswordEncoder().encode("admin"))
    //   .roles("ADMIN")
    //   .build();
    // return new InMemoryUserDetailsManager(normalUser, adminUser);
    return customUserDetailsService;
  }

  @Bean
  BCryptPasswordEncoder getPasswordEncoder() {
    // return NoOpPasswordEncoder.getInstance();
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationProvider getAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(customUserDetailsService);
    provider.setPasswordEncoder(getPasswordEncoder());
    return provider;
  }
}
