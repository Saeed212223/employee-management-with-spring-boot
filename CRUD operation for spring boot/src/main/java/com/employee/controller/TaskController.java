package com.employee.controller;


import com.employee.model.Task;
import com.employee.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    
    @Autowired
    private TaskService taskService;


    // Search for see view and table and url
    @GetMapping("/showTasks")
    public String viewTasks(Model mode){
        mode.addAttribute("alltsklist", taskService.getAllTask());
        return "showTasks";
    }

    // ..........This go to form page task
    @GetMapping("/addTask")
    public String addNewTask(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "addTask";
    }
//    .............This is for storing data into database
    @PostMapping("/StoreTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.save(task);
        return "redirect:/showTasks";
    }

    // thisb is for update
    @GetMapping("updatetask/{id}")
    public String updatetask(@PathVariable(value = "id") long id, Model model){
        Task task = taskService.getById(id);
        model.addAttribute("task", task);
        return "updatetask";
    }

    // this is for delete
    
    @GetMapping("/deleteTask/{id}")
    public String deleteById(@PathVariable(value = "id") long id){
        taskService.deleteById(id);
        return "redirect:/showTasks";
    }

}
