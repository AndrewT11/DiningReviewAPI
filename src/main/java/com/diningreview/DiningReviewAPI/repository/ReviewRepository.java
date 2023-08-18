package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.Review;
import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public class ReviewRepository extends CrudRepository<Review, long> {

}
