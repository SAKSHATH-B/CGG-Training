package cgg.springjwt.jwttokens.dao;

import cgg.springjwt.jwttokens.entities.RefreshToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository
  extends JpaRepository<RefreshToken, Integer> {
  Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
