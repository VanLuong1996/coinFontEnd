package com.feature.gcoin.service;

import com.feature.gcoin.model.CheckInOut;
import org.joda.time.DateTime;

import java.util.List;

public interface CheckInOutService {

    void updateInforCheckInOut(Long userId, boolean isCheck) throws Exception;

    boolean isTheFistCheckInOut(Long userId) throws Exception;

    List<CheckInOut> getHistoryOfUser (Long userId);
}
