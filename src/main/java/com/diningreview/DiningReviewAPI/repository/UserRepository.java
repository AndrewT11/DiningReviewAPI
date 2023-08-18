package com.diningreview.DiningReviewAPI.repository;

import org.springframework.data.repository.CrudRepository;
import com.diningreview.DiningReviewAPI.model.User;

import java.util.List;
import java.util.Optional;


public class UserRepository extends CrudRepository<User, long> {

}
