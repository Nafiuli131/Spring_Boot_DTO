package com.example.demo.service;

import com.example.demo.dto.UserDto;

import com.example.demo.model.User;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class userService  {
    @Autowired
    userRepository userRepository ;



    private userService(com.example.demo.repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserDto> getAllUserList(){
        return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
    public User saveUser(User user){

        return userRepository.save(user);
    }
    public void deleteUser(String email){
         userRepository.delete(userRepository.getUserByEmail(email));
    }
    public User editUser(String email,User user){
        User user1 = userRepository.getUserByEmail(email);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        return userRepository.save(user1);
    }
    //entity to dto
    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserFirstName(user.getFirstName());
        userDto.setUserLastName(user.getLastName());
        userDto.setUserEmail(user.getEmail());
        return userDto;
    }
    //convert DTO to entity
    private User convertDTOtoEntity(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getUserFirstName());
        user.setLastName(userDto.getUserLastName());
        user.setEmail(userDto.getUserEmail());
        return user;
    }
}
