package com.diningreview.DiningReviewAPI.repository;
import com.diningreview.DiningReviewAPI.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    ArrayList<Restaurant> findRestaurantByZipCodeOrderByPeanutScoreDesc(String zipCode);
    ArrayList<Restaurant> findRestaurantByZipCodeOrderEggScoreDesc(String zipCode);
    ArrayList<Restaurant> findRestaurantByZipCodeOrderDairyScoreDesc(String zipCode);
}

