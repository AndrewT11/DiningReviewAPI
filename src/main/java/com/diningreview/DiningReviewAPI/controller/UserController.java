package com.diningreview.DiningReviewAPI.controller;


import com.diningreview.DiningReviewAPI.model.User;
import com.diningreview.DiningReviewAPI.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.Optional; // used to confirm if object isPresent() or not

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
