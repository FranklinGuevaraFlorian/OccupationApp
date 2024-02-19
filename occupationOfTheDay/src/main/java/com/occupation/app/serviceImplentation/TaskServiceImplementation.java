package com.occupation.app.serviceImplentation;

import com.occupation.app.DTO.CreateTask;
import com.occupation.app.DTO.ListTask;
import com.occupation.app.model.Task;
import com.occupation.app.repositoy.TaskRepository;
import com.occupation.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;
    private final String prex = "Task_";
    @Autowired
    public TaskServiceImplementation(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    @Override
    public String generatedIdentifier() {
       String maxIdentifier = taskRepository.maxIdenfitier();
       if(maxIdentifier == null) return prex + 1;
       int numberIdentifier = Integer.valueOf(maxIdentifier.substring(prex.length()));
       numberIdentifier++;
       return prex + numberIdentifier;
    }

    @Override
    public Task createTask(CreateTask data) {
        return this.taskRepository.save(new Task(data,generatedIdentifier()));
    }

    @Override
    public Page<ListTask> listTask(Pageable pageable) {
        return this.taskRepository.findAll(pageable).map(ListTask::new);
    }


}
