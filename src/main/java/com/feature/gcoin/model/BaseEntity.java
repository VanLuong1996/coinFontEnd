package com.feature.gcoin.model;

import javax.persistence.Column;
import java.util.Date;

public class BaseEntity {
    @Column(name = "CREAT_AT")
    private Date creatAt;

    @Column(name = "UPDATE_AT")
    private Date updateAt;

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
