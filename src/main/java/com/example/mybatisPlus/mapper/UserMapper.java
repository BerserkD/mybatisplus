package com.example.mybatisPlus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisPlus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<User> {
     Page<User> seletePageVO(@Param("page") Page<User> page,@Param("age") Integer age);

     int insertSelective(User user);
     int insertAll(User user);
}
