package com.employee.service;
import com.employee.model.Task;
import com.employee.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class TaskServiceIml implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    //  this is for view

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    // thus is for save

    @Override
    public void save(Task task) {
        if(Objects.nonNull(task)){
            taskRepository.save(task);
        }
    }

    // ....this is for eidt
    @Override
    public Task getById(Long id) {
        Task task = null;
        if (Objects.nonNull(id)) {
            Optional<Task> optionalTask = taskRepository.findById(id);
            if(optionalTask.isPresent()){
                task = optionalTask.get();
            }else{
                throw new RuntimeException("Task not found with the id:"+ id);
            }
        }
        return task;
    }


    // this is for delete
    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            taskRepository.deleteById(id);
        }
    }

   
}
