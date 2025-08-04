package com.example.todo.persistence;

import com.example.todo.model.entity.TaskEntity;
import com.example.todo.repository.FileRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 파일을 기반으로 TaskEntity를 저장·조회·수정·삭제하는 DAO 구현체
 */
public class FileTaskDAO implements TaskDAO {
    private final FileRepository repository;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public FileTaskDAO(FileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(TaskEntity task) throws DAOException {
        String line = serialize(task);
        try {
            repository.appendLine(line);
        } catch (IOException e) {
            throw new DAOException("Failed to create task", e);
        }
    }

    @Override
    public List<TaskEntity> readAll() throws DAOException {
        try {
            List<String> lines = repository.readAll();
            List<TaskEntity> tasks = new ArrayList<>();
            for (String line : lines) {
                if (line.isBlank()) continue;
                tasks.add(deserialize(line));
            }
            return tasks;
        } catch (IOException e) {
            throw new DAOException("Failed to read tasks", e);
        }
    }

    @Override
    public void update(TaskEntity task) throws DAOException {
        try {
            List<String> lines = repository.readAll();
            List<String> updated = lines.stream()
                .map(line -> {
                    TaskEntity t = deserialize(line);
                    return (t.getId() == task.getId()) ? serialize(task) : line;
                })
                .collect(Collectors.toList());
            repository.writeAll(updated);
        } catch (IOException e) {
            throw new DAOException("Failed to update task", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try {
            List<String> lines = repository.readAll();
            List<String> filtered = lines.stream()
                .filter(line -> deserialize(line).getId() != id)
                .collect(Collectors.toList());
            repository.writeAll(filtered);
        } catch (IOException e) {
            throw new DAOException("Failed to delete task", e);
        }
    }

    /**
     * TaskEntity를 CSV 형식 문자열로 변환
     */
    private String serialize(TaskEntity task) {
        return String.join(
            ",",
            String.valueOf(task.getId()),
            task.getTitle(),
            task.getContent(),
            task.getDueDate().format(FORMATTER),
            task.getStatus(),
            String.valueOf(task.getPriority())
        );
    }

    /**
     * CSV 형식 문자열을 TaskEntity로 변환
     */
    private TaskEntity deserialize(String line) {
        String[] parts = line.split(",", -1);
        TaskEntity task = new TaskEntity();
        task.setId(Integer.parseInt(parts[0]));
        task.setTitle(parts[1]);
        task.setContent(parts[2]);
        task.setDueDate(LocalDateTime.parse(parts[3], FORMATTER));
        task.setStatus(parts[4]);
        task.setPriority(Integer.parseInt(parts[5]));
        return task;
    }

    @Override
    public Optional<TaskEntity> findById(int id) throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<TaskEntity> findAll() throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void load(String filePath) throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

    @Override
    public void save(String filePath) throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}