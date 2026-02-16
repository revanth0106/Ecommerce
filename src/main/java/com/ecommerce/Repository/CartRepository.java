package com.ecommerce.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.Product;
import com.ecommerce.Entity.User;

public interface CartRepository extends JpaRepository<Cart,Long> {
	Optional<Cart> findByUserAndProduct(User user, Product product);

    List<Cart> findByUser_Id(Long userId);

}
