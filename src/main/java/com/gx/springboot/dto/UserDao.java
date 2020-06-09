package com.gx.springboot.dto;

import com.gx.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @createDate 2020/6/5 17:00
 */
@Repository
public interface UserDao {

    public User findUserById(Integer id);
    public User queryForUser(@Param("userName") String userName, @Param("password") String password);

    public List<User> queryAll();

    public int deleteUser(Integer id);

    public int updateUser(User user);

}
