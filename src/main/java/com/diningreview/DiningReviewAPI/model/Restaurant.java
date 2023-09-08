package com.diningreview.DiningReviewAPI.model;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String streetAddress;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipCode;
    @Column
    private String phoneNumber;
    @Column
    private Float reviewScore;
    @Column
    private Float peanutScore;
    @Column
    private Float eggScore;
    @Column
    private Float dairyScore;
}
