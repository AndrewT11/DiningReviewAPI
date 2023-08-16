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
    private long id;

    private String userName;
    private String city;
    private String state;
    private double zipCode;
    private boolean peanutAllergy;
    private boolean eggAllergy;
    private boolean dairyAllergy;



}
