package com.ecommerce.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.Product;
import com.ecommerce.Entity.User;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Repository.CartRepository;
import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.Repository.UserRepository;
import com.ecommerce.Service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CartRepository cartRepo;

	public CartServiceImpl(UserRepository userRepo, ProductRepository productRepo, CartRepository cartRepo) {
		this.userRepo = userRepo;
		this.productRepo = productRepo;
		this.cartRepo = cartRepo;
	}


	@Override
	public Cart addToCart(Long userId, Long productId, int quantity) {

	    User user = userRepo.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

	    Product product = productRepo.findById(productId)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

	    //Check if product already in cart
	    Cart cart = cartRepo.findByUserAndProduct(user, product)
	            .orElse(new Cart());

	    cart.setUser(user);
	    cart.setProduct(product);

	    if (cart.getId() == null) {
	        cart.setQuantity(quantity);
	    } else {
	        cart.setQuantity(cart.getQuantity() + quantity);
	    }

	    return cartRepo.save(cart);
	}


	@Override
	 public List<Cart> getUserCart(Long userId) {
        return cartRepo.findByUser_Id(userId);
    }

}
