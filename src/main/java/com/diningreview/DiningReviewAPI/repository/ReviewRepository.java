package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.Review;
import com.diningreview.DiningReviewAPI.model.ReviewStatus;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findReviewByRestaurantIdAndStatus(Long restaurantId, ReviewStatus reviewStatus);
    List<Review> findReviewByStatus(ReviewStatus reviewStatus);
}
