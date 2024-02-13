package cgg.springjwt.jwttokens.services;

import cgg.springjwt.jwttokens.dao.RefreshTokenRepository;
import cgg.springjwt.jwttokens.dao.UserRepository;
import cgg.springjwt.jwttokens.entities.RefreshToken;
import cgg.springjwt.jwttokens.entities.User;
import java.time.Instant;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RefreshTokenRepository refreshTokenRepository;

  private long refreshTokenValidity = 2 * 60 * 1000;

  public RefreshToken createRefreshToken(String username) {
    User user = userRepository.findByEmail(username).get();
    RefreshToken refreshToken = user.getRefreshToken();

    if (refreshToken == null) {
      refreshToken =
        RefreshToken
          .builder()
          .refreshToken(UUID.randomUUID().toString())
          .expiry(Instant.now().plusMillis(refreshTokenValidity))
          .user(user)
          .build();
    } else {
      refreshToken.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
    }

    user.setRefreshToken(refreshToken);
    refreshTokenRepository.save(refreshToken);
    return refreshToken;
  }

  public RefreshToken verifyRequestToken(String refreshToken) {
    RefreshToken rt = refreshTokenRepository
      .findByRefreshToken(refreshToken)
      .orElseThrow(() ->
        new RuntimeException("Given Token doesn't exists in DB !!")
      );
    if (rt.getExpiry().compareTo(Instant.now()) < 0) {
      throw new RuntimeException("RefreshToken Expired !!");
    }
    return rt;
  }
}
