package com.feature.gcoin.service;

import org.joda.time.DateTime;

public interface CheckInOutService {

    void updateInforCheckInOut(Long userId);

    boolean isTheFistCheckInOut(Long userId);
}
