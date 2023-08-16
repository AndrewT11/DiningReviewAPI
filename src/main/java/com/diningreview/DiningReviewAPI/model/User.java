package com.diningreview.DiningReviewAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    long id;
    @Column
    String userName;

    public void rateRestaurant(Restaurant restaurant) {

    }
}
