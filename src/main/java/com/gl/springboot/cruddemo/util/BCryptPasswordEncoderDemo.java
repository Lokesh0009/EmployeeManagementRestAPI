
  package com.gl.springboot.cruddemo.util;
  
  import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
  
  public class BCryptPasswordEncoderDemo {
  
  public static void main(String args[]) {
  
  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  
  String plainText = "Welcome";
  
  String cipherEncodedText1 = passwordEncoder.encode(plainText);
  String cipherEncodedText2 = passwordEncoder.encode(plainText);
  String cipherEncodedText3 = passwordEncoder.encode(plainText);

  
  Arrays.asList(cipherEncodedText1, cipherEncodedText2,cipherEncodedText3)
  .forEach(System.out::println);

  
  System.out.println(passwordEncoder.matches(plainText, cipherEncodedText1));
  System.out.println(passwordEncoder.matches(plainText, cipherEncodedText2));
  System.out.println(passwordEncoder.matches(plainText, cipherEncodedText3));

  
  }
  
}
 