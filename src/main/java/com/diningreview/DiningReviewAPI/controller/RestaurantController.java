package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.Restaurant;
import com.diningreview.DiningReviewAPI.repository.RestaurantRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.util.ObjectUtils;

import java.util.Optional;


@RestController
@RequestMapping("/diningreview")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;


    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;

    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Restaurant created")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        
    }
    
    private void validateRestaurant(Restaurant restaurant) {
        validateName(restaurant.getName());
        
        Optional<Restaurant> existingRestaurant = restaurantRepository.findRestaurantByName(restaurant.getName());
        if(existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    
    private void validateName(String name) {
        if(ObjectUtils.isEmpty(name)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
