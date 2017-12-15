package com.feature.gcoin.model;

import org.joda.time.DateTime;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CHECK_IN_OUT")
public class CheckInOut extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id 1

    @Column(name = "USER_ID")
    private Long userId; //2

    @Column(name = "CHECK_IN_TIME")
    private DateTime checkInTime; //3

    @Column(name = "CHECK_OUT_TIME")
    private DateTime checkOutTime; //4

    @Column(name = "TOTAL")
    private DateTime total; //5

    private Date createAt; //6

    private Date updateAt; //7

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

    public DateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(DateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public DateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(DateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public DateTime getTotal() {
        return total;
    }

    public void setTotal(DateTime total) {
        this.total = total;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
