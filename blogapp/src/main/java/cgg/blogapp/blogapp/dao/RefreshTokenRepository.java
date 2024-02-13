package cgg.blogapp.blogapp.dao;

import cgg.blogapp.blogapp.entities.RefreshToken;
import cgg.blogapp.blogapp.entities.User;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RefreshTokenRepository
  extends JpaRepository<RefreshToken, Integer> {
  Optional<RefreshToken> findByRefreshToken(String refreshToken);
  RefreshToken findByUser(User u1);
}
