package com.ydlclass.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener2 {
    @EventListener
    public void sendEmail(OrderEvent event) {
        System.out.println("给"+((Order)event.getSource()).getUsername()+"发email------------"+((Order)event.getSource()).getOrderId());
    }
}
