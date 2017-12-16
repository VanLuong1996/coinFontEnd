package com.feature.gcoin.dto.request;

import org.joda.time.DateTime;

public class CheckInOutRequest {
    public Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
