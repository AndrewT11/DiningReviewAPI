package com.diningreview.DiningReviewAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// no information is persisted here, so no need to add Spring JPA annotations to persist data.

@AllArgsConstructor
@Getter
@Setter
public class AdminReview {
    private boolean reviewAccepted;


}
