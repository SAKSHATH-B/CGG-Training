package cgg.blogapp.blogapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements UserDetails {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private int userId;

  @Column(name = "user_name", nullable = false, length = 100)
  private String name;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_password")
  private String password;

  @Column(name = "user_about")
  private String about;

  private String role;

  @OneToOne(mappedBy = "user")
  @JsonIgnore
  private RefreshToken refreshToken;

  @JsonIgnore
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Post> posts;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    HashSet<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(role));
    return authorities;
  }

  @Override
  public String getUsername() {
    return name;
  }

  @Override
  public String getPassword() {
    return password;
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
}
