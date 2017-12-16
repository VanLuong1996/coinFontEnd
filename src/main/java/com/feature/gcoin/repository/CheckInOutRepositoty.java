package com.feature.gcoin.repository;

import com.feature.gcoin.model.CheckInOut;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CheckInOutRepositoty extends JpaRepository<CheckInOut, Long> {
//
//    @Query("select c from check_in_out c where c.user_id = (:userId) and c.create_at = (:createAt)")
//    public List<CheckInOut> checkInOut(@Param("userId") Long userId, @Param("createAt") DateTime createAt);

    List<CheckInOut> findAllByUserIdAndCreatAt(Long userId, Date creatAt);

    List<CheckInOut> findByUserIdOrderByCreatAt(Long userId);

    CheckInOut findByUserId (Long userId);

    CheckInOut save(CheckInOut checkInOut);
}
