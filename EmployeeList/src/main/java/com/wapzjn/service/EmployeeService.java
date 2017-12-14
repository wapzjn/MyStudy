package com.wapzjn.service;

import com.wapzjn.bean.Employee;

import java.util.List;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 22:43
 **/
public interface EmployeeService {

    //查询所有员工
    List<Employee> getAll();
}
