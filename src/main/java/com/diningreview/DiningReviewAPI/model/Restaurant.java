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
    private String name;
    private String line1;
    private String city;
    private String state;
    private String zipCode;
    private Integer phoneNumber;
    // We will need to use Integer.toString()
    private double reviewAvgScore;
    private double peanutScore;
    private double eggScore;
    private double dairyScore;


}

