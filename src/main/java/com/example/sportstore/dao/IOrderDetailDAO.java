package com.example.sportstore.dao;

import com.example.sportstore.model.Order;
import com.example.sportstore.model.OrderDetail;

import java.util.List;

public interface IOrderDetailDAO {
    public List<OrderDetail> getAllOrderDetail();
    public Iterable<OrderDetail> getOrderDetailByOrder(int OrderID);
    public void save(OrderDetail o);
    public void add(Order or);
    public void update(Order or);
    public void delete(int orderid);
}
