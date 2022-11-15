package com.employee.controller;


import com.employee.model.Department;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;



    @GetMapping("/showDepartment")
    public String viewTasks(Model mode){
        mode.addAttribute("alldplist", departmentService.getAllDepartment());
        return "showDepartment";
    }

    @GetMapping("/addDepartment")
    public String addNewTask(Model model){
        Department department = new Department();
        model.addAttribute("department", department);
        return "addDepartment";
    }

    @PostMapping("/saveDepartment")
    public String saveTask(@ModelAttribute("department") Department task){
        departmentService.save(task);
        return "redirect:/showDepartment";
    }

    @GetMapping("updateDepartment/{id}")
    public String updatetask(@PathVariable(value = "id") long id, Model model){
        Department department = departmentService.getById(id);
        model.addAttribute("department", department);
        return "UpdateDepartment";
    }
    
    @GetMapping("/deleteDepartment/{id}")
    public String deleteById(@PathVariable(value = "id") long id){
        departmentService.deleteById(id);
        return "redirect:/showDepartment";
    }





}
