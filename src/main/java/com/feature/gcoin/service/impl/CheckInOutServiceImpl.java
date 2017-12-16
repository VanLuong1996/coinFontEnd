package com.feature.gcoin.service.impl;

import com.feature.gcoin.model.CheckInOut;
import com.feature.gcoin.repository.CheckInOutRepositoty;
import com.feature.gcoin.service.CheckInOutService;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class CheckInOutServiceImpl implements CheckInOutService {

    @Autowired
    private CheckInOutRepositoty checkInOutRepositoty;

    @Override
    public void updateInforCheckInOut(Long userId) {
        CheckInOut checkInOut = new CheckInOut();
        checkInOut.setUserId(userId);

        if (isTheFistCheckInOut(userId) == true) {
            checkInOut.setCheckInTime(LocalDateTime.now().toDateTime());
            checkInOut.setCreateAt(LocalDateTime.now().toDateTime());
            checkInOut.setTotal((double) 0);
        } else {
            CheckInOut find = checkInOutRepositoty.findByUserId(userId);

            checkInOut.setCreateAt(find.getCreatAt().toDateTime());
            checkInOut.setCheckInTime(find.getCheckInTime().toDateTime());

            checkInOut.setCheckOutTime(LocalDateTime.now().toDateTime());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = null;
            Date d2 = null;
            try {
                d1 = format.parse(checkInOut.getCheckInTime().toString());
                d2 = format.parse(checkInOut.getCheckOutTime().toString());
            } catch (ParseException e) {
            }

            Long diff = d2.getTime() - d1.getTime(); // so gio lam viec

            if (diff >= 8) checkInOut.setTotal(find.getTotal() + 0.5);
        }
        checkInOutRepositoty.save(checkInOut);
    }

    @Override
    public boolean isTheFistCheckInOut(Long userId) {

        DateTime createAt = LocalDateTime.now().toDateTime();

        if (checkInOutRepositoty.findAllByUserIdAndCreateAt(userId, createAt).size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
