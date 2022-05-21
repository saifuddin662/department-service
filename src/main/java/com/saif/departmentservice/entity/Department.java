package com.saif.departmentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_address")
    private String departmentAddress;

    @Column(name = "department_code")
    private String departmentCode;

    @JsonIgnore
    @Column(name = "sys_user")
    private String sysUser = "Saif";

    @JsonIgnore
    @Column(name = "sys_date")
    private Date sysDate = new Date();
}
