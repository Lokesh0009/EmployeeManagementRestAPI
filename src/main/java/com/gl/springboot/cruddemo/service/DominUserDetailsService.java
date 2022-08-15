
  package com.gl.springboot.cruddemo.service;
  
  import org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.core.userdetails.UsernameNotFoundException;
  import org.springframework.stereotype.Service;
  
  import com.gl.springboot.cruddemo.model.DomainUserDetails; import
  com.gl.springboot.cruddemo.model.User; import
  com.gl.springboot.cruddemo.repository.UserRepository;
  
  @Service public class DominUserDetailsService implements UserDetailsService{
  
  private UserRepository userRepository;
  
  public void DomainUserDetailsService (UserRepository userRepository) {
  
  this.userRepository = userRepository; }
  
  
  @Override public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException {
  
  User user = this.userRepository.findByName(username); return new
  DomainUserDetails(user); }
  
  }
 