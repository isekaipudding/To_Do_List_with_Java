package com.example.todo.service;

import java.util.List;

import com.example.todo.model.dto.TaskDTO;

public interface TaskService {
    /** DTO를 받아서 비즈니스 로직 → DAO 호출 */
    TaskDTO addTask(TaskDTO dto) throws ServiceException;

    List<TaskDTO> getAllTasks() throws ServiceException;

    TaskDTO getTaskById(int id) throws ServiceException;

    TaskDTO updateTask(TaskDTO dto) throws ServiceException;

    void removeTask(int id) throws ServiceException;

    void loadData(String filePath) throws ServiceException;

    void saveData(String filePath) throws ServiceException;
}