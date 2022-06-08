package com.masai.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  @NotBlank
  private boolean signup;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isSignup() {
    return signup;
  }

  public void setSignup(boolean signup) {
    this.signup = signup;
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    if (this == obj) return true;
    if (!(obj instanceof User)) return false;
    User user = (User) obj;
    return (
      Objects.equals(username, user.username) &&
      Objects.equals(password, user.password)
    );
  }

  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return Objects.hash(id, username, password, signup);
  }

  @Override
  public String toString() {
    return (
      "User [id=" +
      id +
      ", username=" +
      username +
      ", password=" +
      password +
      ", signup=" +
      signup +
      "]"
    );
  }
}
