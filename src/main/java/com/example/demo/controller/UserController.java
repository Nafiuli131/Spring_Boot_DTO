package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    userService userService;
    @GetMapping("/userList")
    public List<UserDto> getAllUserList(){
        System.out.println("call this api");
        return userService.getAllUserList();
    }

}
