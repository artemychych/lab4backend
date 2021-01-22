package se.ifmo.ru.lab4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.lab4.entities.User;
import se.ifmo.ru.lab4.entities.UserDTO;
import se.ifmo.ru.lab4.services.UsersService;


@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    @Autowired
    private UsersService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin
    @RequestMapping("/logout")
    void logout(){

    }

    @CrossOrigin
    @GetMapping("/signin")
    void login() {
    }

    @CrossOrigin
    @PostMapping("/signup")
    ResponseEntity<String> signUp(@RequestBody UserDTO userDTO) {
        System.out.println("Че то ");
        if(!userService.doesUserExist(userDTO.getUsername())) {
            User user = new User(userDTO.getUsername(), userDTO.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.addUser(user);
            return new ResponseEntity<>("Registered", HttpStatus.CREATED);

        }else return new ResponseEntity<>("This username is already taken", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
