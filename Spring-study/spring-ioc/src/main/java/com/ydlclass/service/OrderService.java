package com.ydlclass.service;

import com.ydlclass.A;
import com.ydlclass.listener.Order;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements ApplicationEventPublisher {
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void publishEvent(Object event) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
    public void aaa(){
        //1
        Order order=new Order("","");

        //2
        applicationEventPublisher.publishEvent(order);
    }
}
