package com.diningreview.DiningReviewAPI.controller;


import com.diningreview.DiningReviewAPI.model.User;
import com.diningreview.DiningReviewAPI.repository.UserRepository;

// Spring controllers lesson
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;




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
    @ResponseStatus(code = HttpStatus.CREATED, reason = "User created")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/{userName}")
    @ResponseStatus(code = HttpStatus.RESET_CONTENT, reason = "User updated")
    public void updateUser(@PathVariable String userName, @RequestBody User updatedInfo) {
        // Validate user exists
        Optional<User> existingUserOptional = this.userRepository.findUserByUserName(userName);
        if(existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            this.userRepository.save(existingUser);
        }

    }

}
