package com.learn.spring_cloud_functions.real_world;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeInfo {

    private List<Employee> employeeList;
}
