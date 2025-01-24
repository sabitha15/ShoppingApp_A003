package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	ProductRepository repository;

	@Override
	public String addProduct(Product product) {
		Product product1 = repository.save(product);
		if (product1 != null)
			return "product saved successfully";
		else
			return "Failed to save the product";
	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public String deleteProduct(int productId) {
		repository.deleteById(productId);
		return "product deleted successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {
		Optional<Product> optional = repository.findById(productId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("No product found with the given id");
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetweenPrice(int initialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return repository.findByProductCategory(category);
	}

	@Override
	public List<Product> getProductsByCategoryAndPrice(String category, int price) {
		return repository.findByProductCategoryAndProductPriceLessThan(category, price);
	}
  



}
