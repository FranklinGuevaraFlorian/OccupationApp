package com.occupation.app.repositoy;

import com.occupation.app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
    @Query("SELECT MAX(T.idTask) FROM TASK AS T")
    String maxIdenfitier();

}
