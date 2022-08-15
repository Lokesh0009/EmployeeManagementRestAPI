
  package com.gl.springboot.cruddemo.model;
  
  
  import java.util.HashSet; import java.util.Set;
  
  import javax.persistence.CascadeType; import javax.persistence.Entity; import
  javax.persistence.FetchType; import javax.persistence.GeneratedValue; import
  javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.persistence.OneToMany; import javax.persistence.Table;
  
  import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data;
  import lombok.NoArgsConstructor;
  
  @Data
  
  @NoArgsConstructor
  
  @Builder
  
  @AllArgsConstructor
  
  @Entity
  
  @Table(name = "users") public class User {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO)
  
  private long userId; private String name; private String email; private
  String password;
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch =
  FetchType.EAGER) private Set<Role> roles;
  
  public void addRole(Role role) {
  
  if(this.roles == null) { this.roles = new HashSet<>(); }
  
  this.roles.add(role); role.getUsers().add(this); 
  }
  
  public String getName() { return name; }
  
  public String getEmail() { return email; }
  
  public String getPassword() { return password; }
  
  public Set<Role> getRoles() { return roles; }
  
  }
 