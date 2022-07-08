package com.ydlclass.service.impl;

import com.ydlclass.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService implements ILogService {

    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addLog(String msg) {

        jdbcTemplate.update("insert into logger(msg) values (?)",msg);

    }
}
