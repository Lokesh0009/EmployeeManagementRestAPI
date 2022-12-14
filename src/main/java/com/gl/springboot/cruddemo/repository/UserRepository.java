
  package com.gl.springboot.cruddemo.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.gl.springboot.cruddemo.model.User;
  
  @Repository public interface UserRepository extends JpaRepository<User,Long>
  {
  
  User findByName(String name);
  
  }
 