package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.DiningReview;
import com.diningreview.DiningReviewAPI.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DiningReviewRepository extends CrudRepository<DiningReviewRepository, Integer> {
    ArrayList<DiningReview>  findDiningReviewByStatus(ReviewStatus reviewStatus);
}
