package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;
  private static final SecureRandom secureRandom = new SecureRandom();
  private static final Base64.Encoder base64encode = Base64.getUrlEncoder();

  public User register(User user) {
    // check if user exists with same username or not
    if (checkUserExist(user)== true)
      return null;

    user.setToken(generateToken());

    return userRepository.save(user);

  }

  private String generateToken() {

    byte[] token = new byte[24];
    secureRandom.nextBytes(token);
    return base64encode.encodeToString(token);
  }

  private boolean checkUserExist(User user) {
    User existingUser = userRepository.findById(user.getUsername()).orElse(null);

    if (existingUser == null)
      return false;
    return true;
  }

  public User login(User user) {

    User existingUser = userRepository.findById(user.getUsername()).orElse(null);

    if(existingUser.getUsername().equals(user.getUsername()) &&
      existingUser.getPassword().equals(user.getPassword()) &&
    existingUser.getRole().equals(user.getRole())) {

      existingUser.setPassword("");
      return existingUser;
    }
    return null;
  }

  public List<User> getAll(){
    return userRepository.findAll();
  }
}


