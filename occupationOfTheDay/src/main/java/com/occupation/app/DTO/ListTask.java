package com.occupation.app.DTO;

import com.occupation.app.model.Task;

import java.time.LocalDate;

public record ListTask(
        String text,
        boolean state,
        LocalDate lastDayTask) {

    public ListTask(Task task){
        this(task.getText(), task.getState(), task.getLastDayTask());
    }
}
