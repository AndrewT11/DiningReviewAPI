package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.User;
import com.diningreview.DiningReviewAPI.repository.UserRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        //need to make a validation using ObjectUtils to check if userName exists or not, and if so, throw error.
        Optional<User> userOptional = this.userRepository.getUserByUserName(user.getUserName());
        if(userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        this.userRepository.save(user);
        return user;
    }

    @PutMapping("/{userName}")
    public User updateUser(@PathVariable("userName") String userName, @RequestBody User user) {
        Optional<User> userToUpdateOptional = this.userRepository.getUserByUserName(userName);
        if(!userToUpdateOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user was not found.");
        }
        User userToUpdate = userToUpdateOptional.get();

        if (user.getCity() != null) {
            userToUpdate.setCity(user.getCity());
        }
        if (user.getState() != null) {
            userToUpdate.setState((user.getState()));
        }
        if (user.getZipCode() != null) {
            userToUpdate.setZipCode(user.getZipCode());
        }
        if (user.getDairyAllergy() != null) {
            userToUpdate.setDairyAllergy(user.getDairyAllergy());
        }
        if(user.getEggAllergy() != null) {
            userToUpdate.setEggAllergy(user.getEggAllergy());
        }
        if(user.getPeanutAllergy() != null) {
            userToUpdate.setPeanutAllergy(user.getPeanutAllergy());
        }

        User updatedUser = this.userRepository.save(userToUpdate);
        return updatedUser;
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String userName) {
        Optional<User> userOptional = this.userRepository.getUserByUserName(userName);
        if(!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
        } else {
            User userExists = userOptional.get();
            return userExists;
        }
    }

    // look back at this
    public void validateUser(User user) {

    }
}
