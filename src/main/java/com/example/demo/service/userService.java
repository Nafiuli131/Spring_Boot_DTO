package com.example.demo.service;

import com.example.demo.dto.UserDto;

import com.example.demo.model.User;
import com.example.demo.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class userService {
    userRepository userRepository ;

    private userService(com.example.demo.repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserDto> getAllUserList(){
        return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserFirstName(user.getFirstName());
        userDto.setUserLastName(user.getLastName());
        userDto.setUserEmail(user.getEmail());
        return userDto;
    }
}
