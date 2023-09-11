package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.DiningReview;
import com.diningreview.DiningReviewAPI.repository.DiningReviewRepository;
import com.diningreview.DiningReviewAPI.repository.RestaurantRepository;
import com.diningreview.DiningReviewAPI.repository.UserRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/diningreview")
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;
    private final UserRepository userRepository;

    private final RestaurantRepository restaurantRepository;

    public DiningReviewController(DiningReviewRepository diningReviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.diningReviewRepository = diningReviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void addDiningReview(@RequestBody DiningReview diningReview) {

    }

}
