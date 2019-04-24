package com.example.sportstore.service;

import com.example.sportstore.dao.OrderDetailDAO;
import com.example.sportstore.model.Order;
import com.example.sportstore.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    OrderDetailDAO orderDetailDAO;

    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailDAO.getAllOrderDetail();
    }

    public Iterable<OrderDetail> getOrderDetailByOrderID(int orderid) {
        return orderDetailDAO.getOrderDetailByOrder(orderid);
    }
    public void save(OrderDetail o) {
        orderDetailDAO.save(o);
    }
    public void add(Order or) {
        orderDetailDAO.add(or);
    }
    public void delete(int orderid){
        orderDetailDAO.delete(orderid);
    }
}
