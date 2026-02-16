package com.ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.CartRequest;
import com.ecommerce.Entity.Cart;
import com.ecommerce.Service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

        @PostMapping
        public Cart addToCart(@RequestBody CartRequest request) {
            return cartService.addToCart(
                    request.getUserId(),
                    request.getProductId(),
                    request.getQuantity()
            );
        }

        @GetMapping("/{userId}")
        public List<Cart> viewCart(@PathVariable Long userId) {
            return cartService.getUserCart(userId);
        }

}
