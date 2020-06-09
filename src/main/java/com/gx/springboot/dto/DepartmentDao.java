package com.gx.springboot.dto;

import com.gx.springboot.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @createDate 2020/6/5 10:17
 */
@Repository
public interface DepartmentDao {

    public List<Department> findAll();

    public Department findDeptById(Integer id);

}
