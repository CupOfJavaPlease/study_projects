package com.example.instazoo.facade;

import com.example.instazoo.DTO.UserDTO;
import com.example.instazoo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(userDTO.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(userDTO.getUsername());
        userDTO.setBio(user.getBio());
        return userDTO;
    }
}
