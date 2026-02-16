package com.ecommerce.Service;

import com.ecommerce.Dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(long userId);
}
