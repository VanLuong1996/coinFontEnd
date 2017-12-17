package com.feature.gcoin.model;

import org.joda.time.DateTime;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "CHECK_IN_OUT")
public class CheckInOut extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id 1

    @Column(name = "USER_ID")
    private Long userId; //2
    @Column(name = "CHECK_IN_TIME")
    private Timestamp checkInTime; //3
    @Column(name = "CHECK_OUT_TIME")
    private Timestamp checkOutTime; //4

    @Column(name = "TOTAL")
    private Double total; //5

    public CheckInOut() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Timestamp checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Timestamp getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Timestamp checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}

