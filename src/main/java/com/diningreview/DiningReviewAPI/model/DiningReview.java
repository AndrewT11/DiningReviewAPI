package com.diningreview.DiningReviewAPI.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class DiningReview {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String userName;
    @Column
    private Long restaurantId;
    @Column
    private Integer peanutScore; // Integer can be divided and cast to Float later
    @Column
    private Integer eggScore;
    @Column
    private Integer dairyScore;
    @Column
    private String review;
    @Column
    private ReviewStatus status;

}
