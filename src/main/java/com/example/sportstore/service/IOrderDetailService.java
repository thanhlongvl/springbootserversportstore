package com.example.sportstore.service;

import com.example.sportstore.model.Order;
import com.example.sportstore.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    public List<OrderDetail> getAllOrderDetail();
    public Iterable<OrderDetail> getOrderDetailByOrderID(int orderid);
    public void save(OrderDetail o);
    public void add(Order or);
    public void delete(int orderid);
}
