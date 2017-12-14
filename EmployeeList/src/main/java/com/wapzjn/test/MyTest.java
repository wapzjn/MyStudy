package com.wapzjn.test;

import com.github.pagehelper.PageInfo;
import com.wapzjn.bean.Department;
import com.wapzjn.bean.Employee;
import com.wapzjn.dao.DepartmentDao;
import com.wapzjn.dao.EmployeeDao;
import com.wapzjn.service.EmployeeService;
import com.wapzjn.util.MyTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 22:10
 **/
/*

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
                                    "classpath:springmvc.xml"})
public class MyTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void myTest() throws Exception {

       MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/emplist").param("pn","1")).andReturn();
        MockHttpServletRequest request = mvcResult.getRequest();
        PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
        System.out.println(pageInfo.getPageNum());
        List<Employee> list = pageInfo.getList();
        for(Employee employee:list){
            System.out.println(employee);
        }
    }
}
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyTest{

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void myTest(){

        Employee employee = new Employee();
        Department department = new Department();
        department.setName("技术部");
        employee.setName("李园园");
        employee.setGender("f");
        employee.setDepartment(department);
        employee.setEmail("wapzjn@gmail.com");
        departmentDao.insert(department);
        for(int i = 0;i<1000;i++){
            employee.setDate(MyTime.format(new Date()));
            employeeDao.insert(employee);
        }
        System.out.println("=============================》插入完成");
    }
}
