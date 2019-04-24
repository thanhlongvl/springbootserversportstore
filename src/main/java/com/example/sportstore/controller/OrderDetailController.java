package com.example.sportstore.controller;

import com.example.sportstore.dao.OrderDetailDAO;
import com.example.sportstore.model.Order;
import com.example.sportstore.model.OrderDetail;
import com.example.sportstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sportstore")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/orderdetail1")
    public void addOrderDetail1(@Valid @RequestBody OrderDetail ord) {
        orderDetailService.save(ord);
    }

    @GetMapping("/orderdetail")
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailService.getAllOrderDetail();
    }

    @GetMapping("orderdetail/{id}")
    public Iterable<OrderDetail> getOrderDetailByOrder(@PathVariable int id) {
        return orderDetailService.getOrderDetailByOrderID(id);
    }

    @GetMapping("test")
    public String test() {
        return "hello Long";
    }

    @RequestMapping(value = "/orderdetail", method = RequestMethod.POST)
    public void add(@RequestBody Order or) {
        orderDetailService.add(or);
    }
    @RequestMapping(value = "/orderdetail/{orderid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int orderid) {
        orderDetailService.delete(orderid);
    }
}
