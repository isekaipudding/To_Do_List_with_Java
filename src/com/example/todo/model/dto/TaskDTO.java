package com.example.todo.model.dto;

public class TaskDTO {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private int priority;
    private String status;

    TaskDTO() {}

    int getId() {return id;}
    void setId(int id) {this.id = id;}

    String getTitle() {return title;}
    void setTitle(String title) {this.title = title;}

    String getDescription() {return description;}
    void setDescription(String description) {this.description = description;}

    String getDueDate() {return dueDate;}
    void setDueDate(String dueDate) {this.dueDate = dueDate;}

    int getPriority() {return priority;}
    void setPriority(int priority) {this.priority = priority;}

    String getStatus() {return status;}
    void setStatus(String status) {this.status = status;}
}