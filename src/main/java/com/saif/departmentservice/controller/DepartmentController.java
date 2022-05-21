package com.saif.departmentservice.controller;

import com.saif.departmentservice.entity.Department;
import com.saif.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    @ResponseBody
    public ResponseEntity<?> getDepartment(@PathVariable Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }
}
