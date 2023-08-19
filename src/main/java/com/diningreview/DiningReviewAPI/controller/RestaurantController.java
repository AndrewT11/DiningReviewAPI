package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.Restaurant;
import com.diningreview.DiningReviewAPI.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/diningreview")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;


    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;

    }


}
