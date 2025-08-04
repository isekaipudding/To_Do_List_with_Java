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

    public TaskEntity() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public LocalDateTime getDueDate() {return dueDate;}
    public void setDueDate(LocalDateTime dueDate) {this.dueDate = dueDate;}

    public int getPriority() {return priority;}
    public void setPriority(int priority) {this.priority = priority;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public LocalDateTime getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

    public CharSequence getContent() {
        throw new UnsupportedOperationException("Unimplemented method 'getContent'");
    }

    public void setContent(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }
}