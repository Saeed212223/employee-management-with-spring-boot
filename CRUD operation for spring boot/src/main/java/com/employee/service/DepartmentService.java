package com.employee.service;
import com.employee.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    void save(Department department);

    Department getById(Long id);

    void deleteById(Long ids);
}
