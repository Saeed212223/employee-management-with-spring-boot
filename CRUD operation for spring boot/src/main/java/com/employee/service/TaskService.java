package com.employee.service;
import com.employee.model.Task;
import java.util.List;
public interface TaskService {
    List<Task> getAllTask();

    void save(Task task);

    Task getById(Long id);

    void deleteById(Long ids);

}
