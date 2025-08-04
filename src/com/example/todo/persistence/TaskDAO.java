package com.example.todo.persistence;

import java.util.List;
import java.util.Optional;

import com.example.todo.model.entity.TaskEntity;

public interface TaskDAO {
    /** 새 할 일 추가 */
    void create(TaskEntity task) throws DAOException;
    /** ID로 조회 */
    Optional<TaskEntity> findById(int id) throws DAOException;
    /** 전체 조회 (필터/정렬 옵션은 나중에 확장) */
    List<TaskEntity> findAll() throws DAOException;
    /** 수정 */
    void update(TaskEntity task) throws DAOException;
    /** 삭제 */
    void delete(int id) throws DAOException;
    /** 불러오기 */
    void load(String filePath) throws DAOException;
    /** 저장하기 */
    void save(String filePath) throws DAOException;
    /** 모든 파일 읽기 */
    List<TaskEntity> readAll() throws DAOException;
}