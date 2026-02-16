package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.Entity.Product;

public interface ProductService {

	
	Product addProduct(Product product);
    List<Product> getAllProducts();
}
