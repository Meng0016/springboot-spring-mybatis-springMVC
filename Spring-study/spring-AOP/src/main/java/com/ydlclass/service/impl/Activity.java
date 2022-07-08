package com.ydlclass.service.impl;

import com.ydlclass.service.IActivity;

public class Activity implements IActivity {
    @Override
    public void sendGift() {
        System.out.println("送了礼物");
    }
}
