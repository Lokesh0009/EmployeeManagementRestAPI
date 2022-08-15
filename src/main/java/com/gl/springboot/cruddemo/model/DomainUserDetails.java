
  package com.gl.springboot.cruddemo.model;
  
  import java.util.Collection; import java.util.stream.Collectors;
  
  import org.springframework.security.core.GrantedAuthority; import
  org.springframework.security.core.authority.SimpleGrantedAuthority; import
  org.springframework.security.core.userdetails.UserDetails;
  
  public class DomainUserDetails implements UserDetails {
  
  private final User user;
  
  public DomainUserDetails(User user) {
  
  this.user = user; }
  
  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
  
  return this.user
		  .getRoles() 
		  .stream() 
		  .map(Role::getRoleName) 
		  .map(roleName  -> "ROLE_" + roleName) 
		  .map(SimpleGrantedAuthority::new)
		  .collect(Collectors.toSet());
  
  
  //return this.user //.getRoles() //.stream() //.map(Role::getRole)
  //.map(roleName -> new SimpleGrantedAuthority(roleName))
  //.collect(Collectors.toSet()); }
  
  @Override public String getPassword() {
  
  return this.user.getPassword(); }
  
  @Override public String getUsername() {
  
  return this.user.getName(); }
  
  @Override public boolean isAccountNonExpired() {
  
  return true; }
  
  @Override public boolean isAccountNonLocked() {
  
  return true; }
  
  @Override public boolean isCredentialsNonExpired() {
  
  return true; }
  
  @Override public boolean isEnabled() {
  
  return true; }
  
  }
 