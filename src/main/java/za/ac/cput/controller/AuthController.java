package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.impl.AuthService;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public User Register(@RequestBody User user) {

    return authService.register(user);


  }

  @GetMapping("/getAll")
  public List<User> getAll(@RequestBody User user){
    return authService.getAll();
  }

  @PostMapping("/login")
  public User login(@RequestBody User user){

    return authService.login(user);

  }
}
