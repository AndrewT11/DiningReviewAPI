package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.*;
import com.diningreview.DiningReviewAPI.repository.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/diningreview")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, UserRepository userRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }
}
