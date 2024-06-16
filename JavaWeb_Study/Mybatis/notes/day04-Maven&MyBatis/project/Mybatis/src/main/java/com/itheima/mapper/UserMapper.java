package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();
    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);

    User select(@Param("username") String username, String password);
    // User select(Collection collection);
}
