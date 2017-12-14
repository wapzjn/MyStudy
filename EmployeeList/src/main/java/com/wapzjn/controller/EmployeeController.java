package com.wapzjn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wapzjn.bean.Employee;
import com.wapzjn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 22:49
 **/

/*处理员工增删改查*/
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*查询员工数据*/
    @RequestMapping("/emplist")
    public String empList(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                          Model model){

        List<Employee> employees = new ArrayList<>();
        //引入pagehelper插件
        //在查询之前使用
        PageHelper.startPage(pn,7);
        //start紧跟着的查询就是分页查询
        employees = employeeService.getAll();
        //使用pageInfo包装查询后的结果
        //将pageInfo交给request即可
        //封装了详细的信息，包括封装的数据
        PageInfo pageInfo = new PageInfo(employees,5);
        model.addAttribute("pageInfo",pageInfo);
        return "emplist";
    }
}
