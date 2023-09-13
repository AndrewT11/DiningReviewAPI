package com.diningreview.DiningReviewAPI.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String zipCode;
    @Column
    private Float reviewScore;
    @Column
    private Float peanutScore;
    @Column
    private Float eggScore;
    @Column
    private Float dairyScore;
}
