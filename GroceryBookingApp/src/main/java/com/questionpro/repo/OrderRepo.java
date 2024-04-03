package com.questionpro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionpro.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
