package com.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskmanagement.dto.LoginDTO;
import com.taskmanagement.dto.UserDTO;
import com.taskmanagement.entity.User;
import com.taskmanagement.repository.UserRepository;

@Service
public class UserService{
    

    @Autowired
    private UserRepository registerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(UserDTO registerDTO){
        if(isPresent(registerDTO))
        {
            System.out.println("Already Present is present");
            return null;
        }
        else{
            System.out.println("Already Present is present");
            User regis = new User(
                registerDTO.getId(),
                registerDTO.getName(),
                registerDTO.getEmail(),
                registerDTO.getUserName(),
                this.passwordEncoder.encode(registerDTO.getPassword()),null
             );
        registerRepo.save(regis);
        return regis;

        } 
    }

    public boolean isPresent(UserDTO userDTO)
    {
        List<User> list = getUsers();
        for(User regs: list)
        {
            if(userDTO.getUserName().equals(regs.getUserName())){
                System.out.println(userDTO.getUserName()+" "+userDTO.getUserName());
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return registerRepo.findAll();
    }



    public LoginResponce  loginEmployee(LoginDTO loginDTO) {
        // String msg = "";
        User register1 = registerRepo.findByUserName(loginDTO.getUserName());
        if (register1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = register1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> register = registerRepo.findOneByUserNameAndPassword(loginDTO.getUserName(), encodedPassword);
                if (register.isPresent()) {
                    return new LoginResponce("Login Success", true,register.get().getId());
                } else {
                    return new LoginResponce("Login Failed", false,null);
                }
            } else {
                return new LoginResponce("password Not Match", false,null);
            }
        }else {
            return new LoginResponce("Email not exits", false,null);
        }
    }

}





