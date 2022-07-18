package com.meng.token.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.token.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Integer userId);
}
