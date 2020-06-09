package com.gx.springboot;

import com.gx.springboot.dto.DepartmentDao;
import com.gx.springboot.dto.EmployeeDao;
import com.gx.springboot.dto.UserDao;
import com.gx.springboot.entity.Department;
import com.gx.springboot.entity.Employee;
import com.gx.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringbootMybatisEmpdemoApplicationTests {

    @Autowired
    UserDao userDao;
    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }



    @Test
    public void testEmp(){
        Employee emp = employeeDao.findEmpById(1001);
        //System.out.println(emp);

        List<Employee> employeeList = employeeDao.findAll();
        for (Employee employee :employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testUpdateEmp(){
        Employee emp = employeeDao.findEmpById(1001);
        emp.setLastName("gx");
        employeeDao.updateEmp(emp);
    }

    @Test
    public void testInsertEmp(){
        Employee emp = new Employee();
        emp.setLastName("lily");
        emp.setGender(0);
        emp.setBirth(new Date());
        emp.setD_id(102);
        emp.setEmail("123@qq.com");
        employeeDao.insertEmp(emp);
    }

    @Test
    public void testDeleteEmp(){
        employeeDao.deleteEmp(1006);
    }

    @Test
    public void testFindUser(){
        User user = userDao.queryForUser("admin", "admin123");
        User user1 = userDao.findUserById(1);
        System.out.println(user);
        System.out.println(user1);
    }

    @Test
    public void testFindDept(){

        List<Department> departments = departmentDao.findAll();

        System.out.println(departments.get(0));
    }
}
