package com.example.springbootshiro.mapper;

import com.example.springbootshiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    public User findByUsername(String username);
}
