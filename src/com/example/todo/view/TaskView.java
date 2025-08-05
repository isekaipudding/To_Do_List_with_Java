package com.example.todo.view;

import com.example.todo.persistence.FileTaskDAO;
import com.example.todo.persistence.DAOException;
import com.example.todo.repository.FileRepository;
import com.example.todo.repository.TextFileRepository;
import com.example.todo.model.entity.TaskEntity;

import java.time.LocalDateTime;

/**
 * 애플리케이션 진입점 클래스 (View 역할)
 * 터미널을 통해 CRUD 동작을 테스트합니다.
 */
public class TaskView {
    public static void main(String[] args) {
        // 파일 경로 설정 (인자 없으면 기본 tasks.txt)
        String filePath = "tasks.txt";
        if (args.length > 0) {
            filePath = args[0];
        }

        FileRepository fileRepo = new TextFileRepository(filePath);
        FileTaskDAO taskDAO = new FileTaskDAO(fileRepo);

        // 샘플 Task 생성
        TaskEntity sample = new TaskEntity();
        sample.setId(1);
        sample.setTitle("샘플 할 일");
        sample.setContent("View에서 테스트용 샘플 할 일 등록");
        sample.setDueDate(LocalDateTime.now().plusDays(3));
        sample.setStatus("NOT_DONE");
        sample.setPriority(1);

        try {
            taskDAO.create(sample);
            System.out.println("[OK] 샘플 할 일 생성 성공: " + sample);

            // 이후 readAll로 전체 목록 확인
            System.out.println("현재 할 일 목록:");
            taskDAO.readAll().forEach(t -> System.out.println(" - " + t));
        } catch (DAOException e) {
            System.err.println("[ERROR] 할 일 생성 또는 조회 실패");
            e.printStackTrace();
        }
    }
}