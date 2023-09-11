package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.Restaurant;
import com.diningreview.DiningReviewAPI.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.Optional;

public class RestaurantController {
    RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(String name, String zipCode) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.getRestaurantByNameAndZipCode(name, zipCode);
        if(restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Restaurant by name and zipcode already exists")
        }
    }

}
