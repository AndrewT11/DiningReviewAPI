package com.diningreview.DiningReviewAPI.controller;

import com.diningreview.DiningReviewAPI.model.Review;
import com.diningreview.DiningReviewAPI.model.ReviewStatus;
import com.diningreview.DiningReviewAPI.model.User;
import com.diningreview.DiningReviewAPI.model.Restaurant;

import com.diningreview.DiningReviewAPI.repository.ReviewRepository;
import com.diningreview.DiningReviewAPI.repository.UserRepository;
import com.diningreview.DiningReviewAPI.repository.RestaurantRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@RequestMapping("/reviews")
@RestController
public class ReviewController {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }
}
