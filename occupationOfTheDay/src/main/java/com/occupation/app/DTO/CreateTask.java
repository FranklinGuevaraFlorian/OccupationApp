package com.occupation.app.DTO;

import java.time.LocalDate;

public record CreateTask(
        String text,
        boolean state,
        LocalDate lastDayTask) {
}
