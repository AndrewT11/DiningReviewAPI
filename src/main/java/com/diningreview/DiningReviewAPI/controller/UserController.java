package com.diningreview.DiningReviewAPI.controller;


import com.diningreview.DiningReviewAPI.model.User;
import com.diningreview.DiningReviewAPI.repository.UserRepository;

// Spring controllers lesson
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.util.ObjectUtils;




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
        // Used to check if the userName already exists. If so, throw ResponseStatus
        validateUser(user);
        // if not exist, save the new user to the repository.
        userRepository.save(user);
    }

    // Edit user
    @PutMapping("/{userName}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "User updated")
    public void updateUser(@PathVariable String userName, @RequestBody User updatedInfo) {

        validateUserName(userName);
        // Validate user exists
        Optional<User> existingUserOptional = this.userRepository.findUserByUserName(userName);
        if(existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            copyUserInfoFrom(updatedInfo, existingUser);
            this.userRepository.save(existingUser);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    private void copyUserInfoFrom(User updatedUser, User existingUser) {
        // there is no .isPresent() method for ObjectUtils, thus we must ! .isEmpty
        if (!ObjectUtils.isEmpty(updatedUser.getUserName())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (!ObjectUtils.isEmpty(updatedUser.getCity())) {
            existingUser.setCity(updatedUser.getCity());
        }
        if (!ObjectUtils.isEmpty(updatedUser.getState())) {
            existingUser.setState((updatedUser.getState()));
        }
        if(!ObjectUtils.isEmpty(updatedUser.getZipCode())) {
            existingUser.setZipCode((updatedUser.getZipCode()));
        }
        if(!ObjectUtils.isEmpty(updatedUser.isPeanutAllergy())) {
            existingUser.setPeanutAllergy(updatedUser.isPeanutAllergy());
        }
        if(!ObjectUtils.isEmpty(updatedUser.isDairyAllergy())) {
            existingUser.setDairyAllergy(updatedUser.isDairyAllergy());
        }
        if(!ObjectUtils.isEmpty(updatedUser.isEggAllergy())) {
            existingUser.setEggAllergy(updatedUser.isEggAllergy());
        }

    }

    // Get User by Id
    @GetMapping("/{userName}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Fetching user")
    public User getUser(@PathVariable String userName) {
        validateUserName(userName);

        Optional<User> existingUserOptional = this.userRepository.findUserByUserName(userName);
        if(existingUserOptional.isEmpty()) {
            // This is how we can throw an exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User existingUser = existingUserOptional.get();
        return existingUser;
    }

    private void validateUser(User user) {
        // Test if an object is empty or null. Returns true i object has a supported type and is empty or null. Thus, we check here if the username is actually valid.
        validateUserName(user.getUserName());

        // Optionals are intended to be used as a return type. Without optionals, your method has a possibility of returning null. We can use optionals as method parameter. Helps you avoid null pointer exceptions. We will be using this in addUser to see if there is already a user with this name.Each name must be unique.
        Optional<User> existingUser = userRepository.findUserByUserName(user.getUserName());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    // Checks if any value in the given array is not null. If all the values are null or the array is null or empty then false is returned. Otherwise, true.
    //.isEmpty() tests if an Object is empty or null.
    private void validateUserName(String userName) {
        if(ObjectUtils.isEmpty(userName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
