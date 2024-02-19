package com.occupation.app.model;

import com.occupation.app.DTO.CreateTask;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idTask")
@Entity
@Table(name = "tb_task")
public class Task {
    @Id
    private String idTask;
    @Column(length = 254, nullable = false)
    private String text;
    @Column(nullable = false,columnDefinition = "boolean default false")
    private Boolean state;
    @Column(nullable = false)
    private LocalDate dayRegistrationTask;
    @Column(nullable = false)
    private LocalDate lastDayTask;

    public Task(CreateTask data, String identifier){
        this.idTask = identifier;
        this.text = data.text();
        this.state = data.state();
        this.dayRegistrationTask = LocalDate.now();
        this.lastDayTask = data.lastDayTask();
    }

}
