package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.Restaurant;
import com.diningreview.DiningReviewAPI.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/")
    public Restaurant addRestaurant(Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.getRestaurantByNameAndZipCode(restaurant.getName(), restaurant.getZipCode());
        if(restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Restaurant by name and zipcode already exists");
        }
        return restaurant;
    }


}
