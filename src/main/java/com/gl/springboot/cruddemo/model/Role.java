
  package com.gl.springboot.cruddemo.model;
  
  
  import java.util.HashSet; import java.util.Set;
  
  import javax.persistence.Entity; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.JoinColumn;
  import javax.persistence.ManyToOne; import javax.persistence.Table;
  
  import org.springframework.data.annotation.Id;
  
  import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data;
  import lombok.EqualsAndHashCode; import lombok.NoArgsConstructor; import
  lombok.ToString;
  
  @Data
  
  @AllArgsConstructor
  
  @NoArgsConstructor
  
  @Builder
  
  @Entity
  
  @Table(name = "roles")
  
  @ToString(exclude = "users")
  
  @EqualsAndHashCode(exclude = "users") public class Role {
  
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.AUTO) private int roleId; private
  String roleName;
  
  @ManyToOne
  
  @JoinColumn(name = "user_id", nullable = false) private Set<User> users;
  
  public Set<User> getUsers(){ if (this.users == null){ this.users = new
  HashSet<>(); } return this.users; }
  
  public String getRole() { return roleName; }
  
  public String getRoleName() { return roleName; }
  
  
  
  }
  
 