package com.adasarca.graphqldemo.model;

import java.time.ZonedDateTime;
import java.util.Date;

public class Vote {

    private int id;
    private ZonedDateTime createdAt;
    private int linkId;
    private int userId;

    public Vote() {}

    public Vote(int linkId, int userId) {
        this.linkId = linkId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
