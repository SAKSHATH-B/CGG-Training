package cgg.springjwt.jwttokens.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// @Data
@Entity
@Table(name = "user1")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// @JsonIgnoreProperties({ "refreshToken" })
public class User implements UserDetails {

  @Id
  private String userId;

  private String username;
  private String password;

  @Column(unique = true)
  private String email;

  private String about;

  @JsonIgnore
  @OneToOne(mappedBy = "user")
  private RefreshToken refreshToken;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
  // @Override
  // public String toString() {
  //   return "userName:" + username;
  // }
}
