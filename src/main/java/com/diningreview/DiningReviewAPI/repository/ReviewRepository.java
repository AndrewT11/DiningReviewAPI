package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.Review;
import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
