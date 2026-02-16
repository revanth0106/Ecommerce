package com.ecommerce.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.Dto.OrderResponse;
import com.ecommerce.Entity.Cart;
import com.ecommerce.Entity.Order;
import com.ecommerce.Entity.User;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Repository.CartRepository;
import com.ecommerce.Repository.OrderRepository;
import com.ecommerce.Repository.UserRepository;
import com.ecommerce.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepo;
    private final OrderRepository orderRepo;
    private final CartRepository cartRepo;

    public OrderServiceImpl(UserRepository userRepo,
                            OrderRepository orderRepo,
                            CartRepository cartRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
    }

    @Override
    public OrderResponse placeOrder(long userId) {

        // Fetch user
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Fetch cart items
        List<Cart> cartItems = cartRepo.findByUser_Id(userId);

        if (cartItems.isEmpty()) {
            throw new ResourceNotFoundException("Cart is empty");
        }

        // Calculate total amount
        double totalAmount = cartItems.stream()
                .mapToDouble(c -> c.getProduct().getPrice() * c.getQuantity())
                .sum();

        // Create order
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());

        orderRepo.save(order);

        // Clear cart
        cartRepo.deleteAll(cartItems);

        // Return response
        return new OrderResponse(
                order.getId(),
                order.getTotalAmount(),
                order.getStatus()
        );
    }
}
