package com.ydlclass.service.impl;

import com.ydlclass.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService implements IOrderService {

    Logger logger= LoggerFactory.getLogger(OrderService.class);
    @Override
    public String order(Integer money) {
        try{
        logger.info("这是order方法");
/*        int i = 1/0;*/
        return "inner try";
        } finally {
            logger.info("finally");
        }

    }


}
