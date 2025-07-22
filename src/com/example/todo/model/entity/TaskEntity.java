package com.example.todo.model.entity;

import java.time.LocalDateTime;

public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private int priority;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    TaskEntity() {}

    int getId() {return id;}
    void setId(int id) {this.id = id;}

    String getTitle() {return title;}
    void setTitle(String title) {this.title = title;}

    String getDescription() {return description;}
    void setDescription(String description) {this.description = description;}

    LocalDateTime getDueDate() {return dueDate;}
    void setDueDate(LocalDateTime dueDate) {this.dueDate = dueDate;}

    int getPriority() {return priority;}
    void setPriority(int priority) {this.priority = priority;}

    String getStatus() {return status;}
    void setStatus(String status) {this.status = status;}

    LocalDateTime getCreatedAt() {return createdAt;}
    void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    LocalDateTime getUpdatedAt() {return updatedAt;}
    void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
}