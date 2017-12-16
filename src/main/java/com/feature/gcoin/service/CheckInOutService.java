package com.feature.gcoin.service;

import org.joda.time.DateTime;

public interface CheckInOutService {

    void updateInforCheckInOut(Long userId) throws Exception;

    boolean isTheFistCheckInOut(Long userId) throws Exception;
}
