package cgg.blogapp.blogapp.services;

import cgg.blogapp.blogapp.dao.RefreshTokenRepository;
import cgg.blogapp.blogapp.dao.UserRepository;
import cgg.blogapp.blogapp.entities.RefreshToken;
import cgg.blogapp.blogapp.entities.User;
import java.time.Instant;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService {

  private long refreshTokenValidity = 2 * 60 * 1000;

  @Autowired
  RefreshTokenRepository refreshTokenRepo;

  @Autowired
  UserRepository userRepo;

  public RefreshToken createToken(String username) {
    User user = userRepo.findByName(username).get();
    RefreshToken refreshToken = user.getRefreshToken();

    if (refreshToken == null) {
      refreshToken =
        RefreshToken
          .builder()
          .refreshToken(UUID.randomUUID().toString())
          .user(userRepo.findByName(username).orElseThrow())
          .expiry(Instant.now().plusMillis(refreshTokenValidity))
          .build();
    } else {
      refreshToken.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
    }

    user.setRefreshToken(refreshToken);
    refreshTokenRepo.save(refreshToken);

    return refreshToken;
  }

  public RefreshToken verifyRefreshToken(String refreshToken) {
    RefreshToken rt = refreshTokenRepo
      .findByRefreshToken(refreshToken)
      .orElseThrow(() ->
        new RuntimeException("Given Token Doesn't exist in DB !!")
      );
    if (rt.getExpiry().compareTo(Instant.now()) < 0) {
      throw new RuntimeException("RefreshToken Expired..!");
    }
    return rt;
  }
}
