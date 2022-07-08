package com.ydlclass.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println("给"+((Order)event.getSource()).getUsername()+"发短信  订单是:"+((Order)event.getSource()).getOrderId());
    }
}
