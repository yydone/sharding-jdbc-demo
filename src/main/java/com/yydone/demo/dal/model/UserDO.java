package com.yydone.demo.dal.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDO {

    private String userId;

    private String userName;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
