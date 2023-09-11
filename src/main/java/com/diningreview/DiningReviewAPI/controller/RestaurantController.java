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

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Integer id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if(restaurantOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No restaurant by this id exists");
        }
        Restaurant restaurant = restaurantOptional.get();
        return restaurant;
    }

    @GetMapping("/search")
    public ArrayList<Restaurant> getRestaurantsByZipCodeAndAllergyScore(@RequestParam String zipCode, @RequestParam String allergy) {

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        if(allergy.equalsIgnoreCase("peanut")) {
            restaurants = this.restaurantRepository.findRestaurantByZipCodeAndPeanutScoreNotNullOrderByPeanutScoreDesc(zipCode);
        } else if (allergy.equalsIgnoreCase("dairy")) {
            restaurants= this.restaurantRepository.findRestaurantByZipCodeAndDairyScoreNotNullOrderDairyScoreDesc(zipCode);
        } else if (allergy.equalsIgnoreCase("egg")) {
            restaurants = this.restaurantRepository.findRestaurantByZipCodeAndEggScoreNotNullOrderEggScoreDesc(zipCode);
        }

        return restaurants;
    }
}
