package com.ydlclass.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextFinish {
    @EventListener
    public void load(ContextRefreshedEvent event){
        System.out.println("容器加载完了  开始主动预热");

    }
}
