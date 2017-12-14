package com.wapzjn.dao;

import com.wapzjn.bean.Department;

import java.util.List;
import java.util.Map;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 21:31
 **/
public interface DepartmentDao {

    void insert(Department department);
    void deleteById(Integer id);
    void update(Department department);
    List<Department> selectAll();
    List<Department> selectCondition(Department department);
}
