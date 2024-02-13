package cgg.springjwt.jwttokens.helper;

import cgg.springjwt.jwttokens.entities.User;
import cgg.springjwt.jwttokens.services.CustomUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);

  @Autowired
  private JwtHelper jwtHelper;

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    String header = request.getHeader("Authorization");
    logger.info("Header : {}", header);

    String username = null;
    String token = null;

    if (header != null && header.startsWith("Bearer")) {
      token = header.substring(7);
      try {
        username = jwtHelper.getUsernameFromToken(token);
      } catch (IllegalArgumentException e) {
        logger.info("Illegal argumnet while fetching the username !!");
        e.printStackTrace();
      } catch (ExpiredJwtException e) {
        logger.info("Given jwt token is expired !!");
        e.printStackTrace();
      } catch (MalformedJwtException e) {
        logger.info("Some change has done in the token !! Invalid Token");
        e.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      logger.info("Invalid Header value");
    }

    //
    if (
      username != null &&
      SecurityContextHolder.getContext().getAuthentication() == null
    ) {
      //fetch user details from username
      User userDetails = userDetailsService.loadUserByUsername(username);
      Boolean validateToken = jwtHelper.validateToken(token, userDetails);

      if (validateToken) {
        //set the authentication
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          userDetails,
          validateToken,
          userDetails.getAuthorities()
        );
        authentication.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
      } else {
        logger.info("Validation fails !!");
      }
    }

    filterChain.doFilter(request, response);
  }
}
