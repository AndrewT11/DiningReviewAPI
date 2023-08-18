package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.Restaurant;

import java.util.Optional;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public class RestaurantRepository extends CrudRepository<Restaurant, long>{

}
