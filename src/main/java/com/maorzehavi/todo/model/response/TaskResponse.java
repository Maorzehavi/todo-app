package com.maorzehavi.todo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TaskResponse {

    private Long id;

    private String title;


    private boolean isCompleted;
}
