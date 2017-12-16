package com.feature.gcoin.repository;

import com.feature.gcoin.model.CheckInOut;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CheckInOutRepositoty extends JpaRepository<CheckInOut, Long> {

    @Query("FROM CheckInOut c where c.userId = :userId and trunc(c.createAt) = trunc(:createAt)")
    public List<CheckInOut> getCheckInOutOfDay(@Param("userId") Long userId, @Param("createAt") Date createAt);

    List<CheckInOut> findAllByUserIdAndCreatAt(Long userId, Date creatAt);

    List<CheckInOut> findByUserIdOrderByCreatAt(Long userId);

    List<CheckInOut> findByUserId (Long userId);

    CheckInOut save(CheckInOut checkInOut);
}
