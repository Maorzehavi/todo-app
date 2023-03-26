package com.maorzehavi.todo.repository;

import com.maorzehavi.todo.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}