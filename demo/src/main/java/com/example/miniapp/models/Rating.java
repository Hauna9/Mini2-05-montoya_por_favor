package com.example.miniapp.models;

import java.time.LocalDateTime;

public class Rating {

    private String id;
    private Long entityId;
    private String entityType;
    private Integer score;
    private String comment;
    private LocalDateTime ratingDate;

    // Default constructor
    public Rating() {
    }

    // Partial constructor (without id and ratingDate)
    public Rating(Long entityId, String entityType, Integer score, String comment) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = LocalDateTime.now(); // Optionally set ratingDate to now
    }

    // Full constructor
    public Rating(String id, Long entityId, String entityType, Integer score, String comment, LocalDateTime ratingDate) {
        this.id = id;
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.ratingDate = ratingDate;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }
}
