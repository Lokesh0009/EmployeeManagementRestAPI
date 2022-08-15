
  package com.gl.springboot.cruddemo.config;
  
  import org.springframework.context.annotation.Configuration; import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter; import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
  org.springframework.security.crypto.password.PasswordEncoder;
  
  @Configuration public class ApplicationSecurityConfiguration extends
  WebSecurityConfigurerAdapter {
  
  public void configure(HttpSecurity http) throws Exception{
  
  http .authorizeRequests() .anyRequest() .authenticated() .and() .formLogin()
  .and() .httpBasic();
  
  }
  
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
  
  auth .inMemoryAuthentication()
  .withUser("Lucky").password(passwordEncoder().encode("Welcome")).roles(
  "USER") .and()
  .withUser("Lokesh").password(passwordEncoder().encode("Welcome")).roles(
  "USER", "ADMIN") .and() .passwordEncoder(passwordEncoder()); }
  
  public PasswordEncoder passwordEncoder() {
  
  
  return new BCryptPasswordEncoder(); }
  
  }
 