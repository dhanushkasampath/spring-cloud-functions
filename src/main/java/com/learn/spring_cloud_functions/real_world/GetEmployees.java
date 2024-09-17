package com.learn.spring_cloud_functions.real_world;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Assume this class is for fetching employee data from database
 *
 * we can call this method as follows
 * curl -H "Content-Type: application/json" localhost:8083/getEmployees
 *
 * Then in the cmd we can see we get this list.
 *
 * we can deploy this to aws. need to check on that
 */
@Slf4j // this annotation comes with lombok. then no need to define logger as follows
//  Logger logger = LoggerFactory.getLogger(ToUpperCaseByClass.class);
public class GetEmployees implements Supplier<EmployeeInfo> {
    @Override
    public EmployeeInfo get() {
        log.info("get method in GetEmployees called.!!");
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeList(getEmployeeList());
        return employeeInfo;
    }

    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "David", 22, "Colombo"));
        employeeList.add(new Employee(2, "Mard", 34, "Perth"));
        employeeList.add(new Employee(3, "John", 43, "KL"));
        employeeList.add(new Employee(4, "Naleem", 32, "Galle"));
        return employeeList;
    }
}
