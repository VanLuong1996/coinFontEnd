package com.feature.gcoin.service.impl;

import com.feature.gcoin.model.CheckInOut;
import com.feature.gcoin.repository.CheckInOutRepositoty;
import com.feature.gcoin.service.CheckInOutService;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CheckInOutServiceImpl implements CheckInOutService{

    @Autowired
    private CheckInOutRepositoty checkInOutRepositoty;

    @Override
    public void updateInforCheckInOut(Long userId) {
        CheckInOut checkInOut = new CheckInOut();
        if(isTheFistCheckInOut(userId)==true){
            checkInOut.setCheckInTime(LocalDateTime.now().toDateTime());
            checkInOut.setTotal(null);
        }else {
            checkInOut.setCheckOutTime(LocalDateTime.now().toDateTime());
            checkInOut.setTotal();
        }
        checkInOutRepositoty.save(checkInOut);
    }

    @Override
    public boolean isTheFistCheckInOut(Long userId) {
        DateTime createAt = LocalDateTime.now().toDateTime();
        if(checkInOutRepositoty.findAllByUserIdAndCreateAt(userId, createAt).size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
