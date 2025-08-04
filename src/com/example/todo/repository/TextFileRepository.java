package com.example.todo.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/**
 * 텍스트 파일을 통해 строк 단위로 데이터를 읽고 쓰는 Repository 구현체
 */
public class TextFileRepository implements FileRepository {
    private final Path filePath;

    public TextFileRepository(String path) {
        this.filePath = Paths.get(path);
    }

    @Override
    public List<String> readAll() throws IOException {
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
            return Collections.emptyList();
        }
        return Files.readAllLines(filePath);
    }

    @Override
    public void appendLine(String line) throws IOException {
        Files.write(
            filePath,
            Collections.singletonList(line),
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
    }

    @Override
    public void writeAll(List<String> lines) throws IOException {
        Files.write(
            filePath,
            lines,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    @Override
    public List<String> readLines() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readLines'");
    }

    @Override
    public void overwriteLines(List<String> lines) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'overwriteLines'");
    }
}