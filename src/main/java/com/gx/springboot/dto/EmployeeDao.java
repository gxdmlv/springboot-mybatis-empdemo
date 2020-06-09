package com.gx.springboot.dto;

import com.gx.springboot.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @createDate 2020/6/5 10:18
 */
@Repository
public interface EmployeeDao {

    public Employee findEmpById(Integer id);

    public int updateEmp(Employee employee);

    public int insertEmp(Employee employee);

    public int deleteEmp(Integer id);

    public List<Employee> findAll();
}
