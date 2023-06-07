package com.kreitek.store.infraestructure.rest;

import com.kreitek.store.application.dto.UserLoginDTO;
import com.kreitek.store.application.dto.UserRegisterDTO;
import com.kreitek.store.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserRestController {

    private final UserService userService;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping(value = "/users", produces = "application/json", consumes = "application/json")
    ResponseEntity<UserRegisterDTO> insertUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        UserRegisterDTO userSaved = this.userService.saveUser(userRegisterDTO);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    ResponseEntity<UserRegisterDTO> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        //
        UserRegisterDTO userLogin = this.userService.loginUser(userLoginDTO);
        return new ResponseEntity<>(userLogin, HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping(value = "/users/{userId}")
    ResponseEntity<UserRegisterDTO> getUserById(@PathVariable Long userId) {
        Optional<UserRegisterDTO> user = this.userService.getUserById(userId);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
