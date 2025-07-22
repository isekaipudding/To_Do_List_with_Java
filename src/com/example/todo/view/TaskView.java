package com.example.todo.view;

import java.util.List;

import com.example.todo.model.dto.TaskDTO;

public interface TaskView {
    /** 사용자에게 메시지 출력 */
    void showMessage(String msg);
    /** Task 목록 갱신해서 화면에 표시 */
    void displayTasks(List<TaskDTO> tasks);
    /** 오류 알림 */
    void displayError(String errorMsg);
}