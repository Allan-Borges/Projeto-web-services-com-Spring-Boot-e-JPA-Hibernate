package com.alandev.webservices.rerpositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alandev.webservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
