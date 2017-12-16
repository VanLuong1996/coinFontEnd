package com.feature.gcoin.service.impl;

import com.feature.gcoin.common.TimeProvider;
import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.model.CheckInOut;
import com.feature.gcoin.model.TransactionLog;
import com.feature.gcoin.model.User;
import com.feature.gcoin.repository.CheckInOutRepositoty;
import com.feature.gcoin.repository.TransactionLogRepository;
import com.feature.gcoin.service.CheckInOutService;
import com.feature.gcoin.service.TransactionLogService;
import com.feature.gcoin.service.UserService;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CheckInOutServiceImpl implements CheckInOutService{

    @Autowired
    private CheckInOutRepositoty checkInOutRepositoty;
    @Autowired
    private UserService userService;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    private TransactionLog transactionLog = new TransactionLog();

    @Override
    public void updateInforCheckInOut(Long userId) throws Exception {
        CheckInOut checkInOut = new CheckInOut();
        CheckInOut checkInOutTemp = new CheckInOut();
        Date date = new Date();
        if (isTheFistCheckInOut(userId) == true) {
            checkInOut.setCheckInTime(date);
            checkInOut.setCreatAt(date);
            checkInOut.setUserId(userId);
        } else {
            checkInOutTemp = checkInOutRepositoty.findByUserId(userId).get(0);
            checkInOutTemp.setCheckOutTime(date);
            checkInOutTemp.setUpdateAt(date);
            checkInOutTemp.setUserId(userId);
            checkInOutTemp.setTotal(Double.valueOf(1));
        }

        transactionLog.setCreatAt(date);
        transactionLog.setCoin(1L);
        transactionLog.setTransactionLog("Check in check out");
        transactionLog.setType("ADD_COIN");
        transactionLog.setUpdateAt(date);
        transactionLog.setUserReceiveId(userId);

        transactionLogRepository.save(transactionLog);
        checkInOutRepositoty.save(checkInOutTemp);
    }

    @Override
    public boolean isTheFistCheckInOut(Long userId) throws Exception {
        List<CheckInOut> listUser = checkInOutRepositoty.findByUserIdOrderByCreatAt(userId);
        if (listUser.size() == 0) {
            return true;
        } else {
            CheckInOut checkInOut = listUser.get(0);
            if (checkInOut.getCreatAt().compareTo(new Date()) == 0) {
                if (checkInOut.getCheckInTime() == null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    @Override
    public List<CheckInOut> getHistoryOfUser(Long userId){
        List<CheckInOut> history = checkInOutRepositoty.findByUserId(userId);
        return history;
    }
}
