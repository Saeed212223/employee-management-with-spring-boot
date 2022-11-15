package com.employee.service;
import com.employee.model.Department;
import com.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServicempl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


    @Override
    public void save(Department department) {
        if(Objects.nonNull(department)){
            departmentRepository.save(department);
        }
    }


    @Override
    public Department getById(Long id) {
        Department department = null;
        if (Objects.nonNull(id)) {
            Optional<Department> optionalDepartment = departmentRepository.findById(id);
            if(optionalDepartment.isPresent()){
                department = optionalDepartment.get();
            }else{
                throw new RuntimeException("department not found with the id:"+ id);
            }
        }
        return department;
    }


    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            departmentRepository.deleteById(id);
        }
    }
    
}
