package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.User;
import com.diningreview.DiningReviewAPI.repository.UserRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        //need to make a validation using ObjectUtils to check if userName exists or not, and if so, throw error
        this.userRepository.save(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user was not found.");
        } else {
            User userExists = userOptional.get();
            this.userRepository.save(userExists);
            return user;
        }

    }
}
