package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.userService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    userService userService;
    @Autowired
     ModelMapper modelMapper;
    @GetMapping("/userList")
    public List<UserDto> getAllUserList(){
        System.out.println("call this api");
        return userService.getAllUserList();
    }
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody UserDto userDto){

        User user = modelMapper.map(userDto,User.class);

        return userService.saveUser(user);

    }
    @PutMapping("/editUser/{email}")
    public User editUser(@PathVariable("email") String email, @RequestBody UserDto userDto){
        User user1 = modelMapper.map(userDto,User.class);
        return userService.editUser(email,user1);

    }
    @DeleteMapping("/deleteUser/{email}")
    public void deleteUser(@PathVariable("email") String email){

       userService.deleteUser(email);
    }

}
