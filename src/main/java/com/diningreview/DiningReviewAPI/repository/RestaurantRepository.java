package com.diningreview.DiningReviewAPI.repository;
import com.diningreview.DiningReviewAPI.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    ArrayList<Restaurant> findRestaurantByZipCodeAndPeanutScoreNotNullOrderByPeanutScoreDesc(String zipCode);
    ArrayList<Restaurant> findRestaurantByZipCodeAndEggScoreNotNullOrderEggScoreDesc(String zipCode);
    ArrayList<Restaurant> findRestaurantByZipCodeAndDairyScoreNotNullOrderDairyScoreDesc(String zipCode);
}

