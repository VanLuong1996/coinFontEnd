package com.feature.gcoin.repository;

import com.feature.gcoin.model.CheckInOut;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckInOutRepositoty extends JpaRepository<CheckInOut, Long> {

//    @Query("select c from check_in_out c where c.user_id = (:userId) and c.create_at = (:createAt)")
//    public List<CheckInOut> checkInOut(@Param("userId") Long userId, @Param("createAt") DateTime createAt);

    List<CheckInOut> findAllByUserIdAndCreateAt(Long userId, DateTime createAt);

    CheckInOut save(CheckInOut checkInOut);
}
