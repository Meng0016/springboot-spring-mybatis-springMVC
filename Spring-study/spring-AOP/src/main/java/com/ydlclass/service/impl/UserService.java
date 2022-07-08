package com.ydlclass.service.impl;

import com.ydlclass.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
@Service
public class UserService implements IUserService {
    Logger logger= LoggerFactory.getLogger(OrderService.class);

    @Override
    public void register() {

        logger.info("这是注册方法");
    }
}
