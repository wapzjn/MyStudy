package com.wapzjn.service;

import com.wapzjn.bean.Employee;
import com.wapzjn.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 22:43
 **/

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {

        return employeeDao.selectAll();
    }
}
