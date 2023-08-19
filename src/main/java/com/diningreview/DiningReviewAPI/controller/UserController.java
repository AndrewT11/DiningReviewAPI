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

    // Edit user
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

    // Get User by Id
    @GetMapping("/{userName}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Fetching user")
    public User getUser(@PathVariable String userName) {
        Optional<User> existingUserOptional = this.userRepository.findUserByUserName(userName);
        if(!existingUserOptional.isPresent()) {
            // This is how we can throw an exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User existingUser = existingUserOptional.get();
        return existingUser;
    }

}
