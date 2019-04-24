package com.example.sportstore.model;

import java.util.List;

public class Order {
    private int orderid;
    private List<OrderDetail> products;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public List<OrderDetail> getProducts() {
        return products;
    }

    public void setProducts(List<OrderDetail> products) {
        this.products = products;
    }
}
