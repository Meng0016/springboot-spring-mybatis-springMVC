package com.meng.token.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.token.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
