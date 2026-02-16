package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.Entity.Cart;

public interface CartService {

	Cart addToCart(Long userId, Long productId, int quantity);
	
	 public List<Cart> getUserCart(Long userId) ;
}
