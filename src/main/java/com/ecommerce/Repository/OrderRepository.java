package com.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
