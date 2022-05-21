package com.saif.departmentservice.service;

import com.saif.departmentservice.entity.Department;
import com.saif.departmentservice.repository.DepartmentRepository;
import org.hibernate.AnnotationException;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.hibernate.tool.schema.spi.SchemaManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public ResponseEntity<?> saveDepartment(Department department) {
        try {
            departmentRepository.save(department);
            return ResponseEntity.status(HttpStatus.OK).body("Save Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong!");
        }
    }

    public ResponseEntity<?> getDepartment(Long departmentId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(departmentRepository.findById(departmentId).get());
        } catch (HibernateException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Data persistence Error" + e);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such Data" + e);
        } catch (HttpServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error" + e);
        }
    }
}
