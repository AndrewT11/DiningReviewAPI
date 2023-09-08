package com.diningreview.DiningReviewAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String userName;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipCode;
    @Column
    private Boolean peanutAllergy;
    @Column
    private Boolean eggAllergy;
    @Column
    private Boolean dairyAllergy;
}
