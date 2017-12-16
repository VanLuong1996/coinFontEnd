package com.feature.gcoin.model;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREAT_AT")
    protected DateTime creatAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_AT")
    protected DateTime updateAt;

    public BaseEntity() {
    }

    public DateTime getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(DateTime creatAt) {
        this.creatAt = creatAt;
    }

    public DateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(DateTime updateAt) {
        this.updateAt = updateAt;
    }
}
