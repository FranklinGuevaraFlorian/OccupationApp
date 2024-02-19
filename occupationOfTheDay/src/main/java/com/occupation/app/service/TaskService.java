package com.occupation.app.service;

import com.occupation.app.DTO.CreateTask;
import com.occupation.app.DTO.ListTask;
import com.occupation.app.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TaskService {

    public String generatedIdentifier();

    public Task createTask(CreateTask data);

    public Page<ListTask> listTask(Pageable pageable);
}
