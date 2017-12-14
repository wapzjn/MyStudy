package com.wapzjn.dao;

import com.wapzjn.bean.Employee;

import java.util.List;
import java.util.Map;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 21:34
 **/
public interface EmployeeDao {

    void insert(Employee employee);
    void deleteById(Integer id);
    void update(Employee employee);
    List<Employee> selectAll();
    List<Employee> selectCondition(Employee employee);
}
