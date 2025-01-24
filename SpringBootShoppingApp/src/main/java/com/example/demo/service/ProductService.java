package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;

public interface ProductService {

	public abstract String addProduct(Product product);

	public abstract Product updateProduct(Product product);

	public abstract String deleteProduct(int productId);

	public abstract Product getProductById(int productId) throws ProductNotFound;

	public abstract List<Product> getAllProducts();

	public abstract List<Product> getAllProductsBetweenPrice(int initialPrice, int finalPrice);

	public List<Product> getProductsByCategory(String category);

	public List<Product> getProductsByCategoryAndPrice(String category, int price);
}
