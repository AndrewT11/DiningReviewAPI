package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.Restaurant;

import java.util.Optional;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    Optional<Restaurant> findRestaurantByNameAndZipCode(String name, Double zipCode);
}
