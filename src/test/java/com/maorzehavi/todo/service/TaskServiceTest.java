package com.maorzehavi.todo.service;

import com.maorzehavi.todo.model.request.TaskRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
    void createTask() {
        taskService.createTask(TaskRequest.builder()
                        .title("Test")
                        .isCompleted(false)
                .build());
    }
}