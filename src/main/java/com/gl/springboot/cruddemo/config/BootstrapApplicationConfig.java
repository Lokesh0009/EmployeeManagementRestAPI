package com.gl.springboot.cruddemo.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.javafaker.Faker;
import com.gl.springboot.cruddemo.dao.EmployeeRepository;
import com.gl.springboot.cruddemo.entity.Employee;
import com.gl.springboot.cruddemo.model.Role;
import com.gl.springboot.cruddemo.model.User;
import com.gl.springboot.cruddemo.model.DomainUserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.gl.springboot.cruddemo.repository.UserRepository;
import java.time.ZoneId;
import java.util.HashSet;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class BootstrapApplicationConfig implements ApplicationListener<ApplicationReadyEvent> {
	
	private final EmployeeRepository employeeRepository;
	

    private final Faker faker = new Faker();

    public BootstrapApplicationConfig(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
		
     
    }

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
				
		for (int index = 0; index < 10; index ++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String domainName = faker.internet().domainName();
			
			Employee employee = new Employee(firstName, lastName, firstName+"."+lastName+ "@"+ domainName);
			this.employeeRepository.save(employee);
		}
	}
	
	
	  User Lucky =
	  User.builder().username("Lucky").password(passwordEncoder.encode("Welcome")).
	  build(); User Lokesh =
	  User.builder().username("Lokesh").password(passwordEncoder.encode("Welcome"))
	  .build();
	  
	  
	  
	  Role userRole = Role.builder().role("ROLE_USER").build(); Role adminRole=
	  Role.builder().role("ADMIN_USER").build();
	  
	  Lucky.addRole(userRole); Lokesh.addRole(adminRole); Lokesh.addRole(userRole);
	  
	  this.userRepository.save(Lucky); this.userRepository.save(Lokesh);
	 

	
	
}
