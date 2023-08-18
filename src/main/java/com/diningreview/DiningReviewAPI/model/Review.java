package com.diningreview.DiningReviewAPI.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

// Believe we will need to create an enum class for 1-5 choices, as it needs to be limited.
// asked to include Spring Data JPA notations. But this isn't the Repository
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private long restaurantId;
    private Double peanutScore = null;
    private Double eggScore = null;
    private Double dairyScore = null;

    private String comment = null;

    private ReviewStatus status;
}
