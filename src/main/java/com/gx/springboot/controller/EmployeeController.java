package com.gx.springboot.controller;

import com.gx.springboot.dto.DepartmentDao;
import com.gx.springboot.dto.EmployeeDao;
import com.gx.springboot.entity.Department;
import com.gx.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

/**
 * @createDate 2020/6/5 12:59
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping(value = "/emp/empman", method = RequestMethod.GET)
    public String toEmpManagerPage(Model model) {

        List<Employee> employees = employeeDao.findAll();
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    @RequestMapping(value = "/emp/toaddpage", method = RequestMethod.GET)
    public String toAddPage(Model model) {

        List<Department> departments = departmentDao.findAll();
        model.addAttribute("departments",departments);
        return "/emp/add";
    }

    @RequestMapping(value = "/emp/addemp",method = RequestMethod.POST)
    public String addEmp(Employee employee) {

        //System.out.println(employee.toString());
        employeeDao.insertEmp(employee);
        return "redirect:/emp/empman";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String toEditPage(@PathVariable("id") Integer id, Model model){

        Employee employee = employeeDao.findEmpById(id);
        model.addAttribute("emp",employee);

        List<Department> departments = departmentDao.findAll();
        model.addAttribute("depts",departments);
        return "/emp/edit";
    }


    @RequestMapping(value = "/emp/edit",method = RequestMethod.PUT)
    public String editEmp(Employee employee){


        employeeDao.updateEmp(employee);

        return "redirect:/emp/empman";
    }


    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id){

        employeeDao.deleteEmp(id);
        return "redirect:/emp/empman";
    }

}
