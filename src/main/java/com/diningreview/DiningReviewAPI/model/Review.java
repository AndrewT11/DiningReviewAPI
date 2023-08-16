package com.diningreview.DiningReviewAPI.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

// Believe we will need to create an enum class for 1-5 choices, as it needs to be limited.
@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private long restaurantId;
    private String peanutScore = null;
    private String eggScore = null;
    private String dairyScore = null;

    private String comment = null;

    public Review(String userName, long restaurantId) {
        this.userName = userName;
        this.restaurantId = restaurantId;
    }
}
