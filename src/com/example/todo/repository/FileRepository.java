package com.example.todo.repository;

import java.io.IOException;
import java.util.List;

public interface FileRepository {
    /** 행(레코드) 단위로 읽기 */
    List<String> readLines() throws IOException;
    /** 행 추가 */
    void appendLine(String line) throws IOException;
    /** 전체 덮어쓰기 */
    void overwriteLines(List<String> lines) throws IOException;
    /** 모든 파일 읽기 */
    List<String> readAll() throws IOException;
    /** 모든 파일 쓰기 */
    void writeAll(List<String> lines) throws IOException;
}