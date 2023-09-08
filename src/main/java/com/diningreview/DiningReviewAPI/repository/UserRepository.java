package com.diningreview.DiningReviewAPI.repository;

import com.diningreview.DiningReviewAPI.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> getUserByUserName(String userName);

}
