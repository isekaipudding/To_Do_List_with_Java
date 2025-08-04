package com.example.todo;

import com.example.todo.persistence.FileTaskDAO;
import com.example.todo.persistence.DAOException;
import com.example.todo.repository.FileRepository;
import com.example.todo.repository.TextFileRepository; // 구현 예정
import com.example.todo.model.entity.TaskEntity;

import java.time.LocalDateTime;

/**
 * 애플리케이션 진입점 클래스
 * CRUD 기능 테스트를 Main 메소드에서 실행합니다.
 */
public class Main {
    public static void main(String[] args) {
        // 파일 경로 설정 (인자 없으면 기본 tasks.csv)
        String filePath = "tasks.csv";
        if (args.length > 0) {
            filePath = args[0];
        }

        // TODO: TextFileRepository 구현 후 해당 클래스 사용
        FileRepository fileRepo = new TextFileRepository(filePath);
        FileTaskDAO taskDAO = new FileTaskDAO(fileRepo);

        // 샘플 Task 생성
        TaskEntity sample = new TaskEntity();
        sample.setId(1);
        sample.setTitle("샘플 할 일");
        sample.setContent("Main에서 테스트용 샘플 할 일 등록");
        sample.setDueDate(LocalDateTime.now().plusDays(3));
        sample.setStatus("NOT_DONE");
        sample.setPriority(1);

        try {
            taskDAO.create(sample);
            System.out.println("[OK] 샘플 할 일 생성 성공: " + sample);
        } catch (DAOException e) {
            System.err.println("[ERROR] 할 일 생성 실패");
            e.printStackTrace();
        }
    }
}