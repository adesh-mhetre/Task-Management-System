package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.dto.LoginDTO;
import com.taskmanagement.dto.UserDTO;
import com.taskmanagement.entity.User;
import com.taskmanagement.service.LoginResponce;
import com.taskmanagement.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
public class UserController {

    @Autowired
    private UserService registerService;



    // @PostMapping("/register")
    // public Register saveLogin(@RequestBody RegisterDTO login) {
    //     return registerServiceImpl.addCustomer(login);
    // }   

    // @GetMapping("/getRegisterCustomer")
    // public List<Register> hello() {
    //     return registerServiceImpl.getRegisterCustomer();
    // }   

    @PostMapping("/save")
    public User  addCustomer(@RequestBody UserDTO registerDTO) {
             return registerService.addUser(registerDTO);
            
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponce loginResponse = registerService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}

