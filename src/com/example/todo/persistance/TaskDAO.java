package com.example.todo.persistance;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.example.todo.model.entity.TaskEntity;

public interface TaskDAO {
    /** 새 할 일 추가 */
    void create(TaskEntity task) throws IOException;
    /** ID로 조회 */
    Optional<TaskEntity> findById(int id) throws IOException;
    /** 전체 조회 (필터/정렬 옵션은 나중에 확장) */
    List<TaskEntity> findAll() throws IOException;
    /** 수정 */
    void update(TaskEntity task) throws IOException;
    /** 삭제 */
    void delete(int id) throws IOException;
}