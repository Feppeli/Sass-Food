package com.Food.Food.Controllers;

import com.Food.Food.Model.UserModel;
import com.Food.Food.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String receiveUser(@RequestBody UserModel user){
        userRepository.save(user);
        return "User? " + user.getName() + "Save in DB!";
    }

}
