package com.maorzehavi.todo.service;

import com.maorzehavi.todo.model.entity.Task;
import com.maorzehavi.todo.model.request.TaskRequest;
import com.maorzehavi.todo.model.response.TaskResponse;
import com.maorzehavi.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public Optional<TaskResponse> createTask(TaskRequest taskRequest) {
        return Optional.of(modelMapper.map(taskRepository.save(modelMapper.map(taskRequest, Task.class)), TaskResponse.class));
    }

    public Optional<TaskResponse> getTask(Long id) {
        var task = taskRepository.findById(id);
        return task.map(value -> modelMapper.map(value, TaskResponse.class));
    }

    public Optional<TaskResponse> updateTask(Long id, TaskRequest taskRequest) {
        var task = taskRepository.findById(id);
        if (task.isEmpty()) {
            return Optional.empty();
        }
        task.get().setTitle(taskRequest.getTitle());
        task.get().setCompleted(taskRequest.isCompleted());
        return Optional.of(modelMapper.map(taskRepository.save(task.get()), TaskResponse.class));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<List<TaskResponse>> getAllTasks() {
        return Optional.of(taskRepository.findAll().stream().map(task -> modelMapper.map(task, TaskResponse.class)).collect(Collectors.toList()));

    }
}
