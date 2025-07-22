package com.example.todo.controller;

public interface TaskController {
    /** 사용자 입력 받아서 새 Task 생성 */
    void onCreate(String title, String desc, String dueDate, int priority);
    /** 화면에 전체 Task 그리기 */
    void onReadAll();
    /** 수정 요청 처리 */
    void onUpdate(int id, String title, String desc, String dueDate, int priority, String status);
    /** 삭제 요청 처리 */
    void onDelete(int id);
}