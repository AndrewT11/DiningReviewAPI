package com.diningreview.DiningReviewAPI.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    String address;
    Integer phoneNumber;
    double reviewScore;
    double peanut;
    double egg;
    double dairy;


}

