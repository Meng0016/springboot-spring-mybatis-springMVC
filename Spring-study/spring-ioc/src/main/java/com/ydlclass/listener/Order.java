package com.ydlclass.listener;

public class Order {
    private String orderId;

    private String username;

    public Order(String orderId, String username) {
        this.orderId = orderId;
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
