package com.example.sportstore.repository;

import com.example.sportstore.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
}
