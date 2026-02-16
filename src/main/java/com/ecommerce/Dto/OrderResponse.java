package com.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {

	
	private long orderId;
	private double amount;
	private String status;
}
