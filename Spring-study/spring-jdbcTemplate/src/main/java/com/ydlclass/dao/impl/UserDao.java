package com.ydlclass.dao.impl;

import com.ydlclass.dao.IUserDao;
import com.ydlclass.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Override
    public User selectById(int id) {

        List<User> query= jdbcTemplate.query("select * from user where id = ?", (rs,i)-> {

                String username = rs.getString("username");
                String password = rs.getString("password");
                int id1 = rs.getInt("id");
                return new User(id1,username,password);

        }, id);
        return query.size()==0 ? null : query.get(0);
    }
    public List<User> select(){

        List<User> users =jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));
        for (User user:users){
            System.out.println(user);
        }

        return users;
    }
}
