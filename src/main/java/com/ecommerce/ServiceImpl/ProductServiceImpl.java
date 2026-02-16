package com.ecommerce.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Entity.Product;
import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.Service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	

	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public Product addProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	}
}
