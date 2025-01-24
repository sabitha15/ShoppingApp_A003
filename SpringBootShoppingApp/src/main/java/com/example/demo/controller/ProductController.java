package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	ProductService service;

	@PostMapping("/save") // http://localhost:1234/products/save
	public String saveProduct(@RequestBody Product product) {
		logger.info("products added in the cotroller");
		return service.addProduct(product);
	}

	@PutMapping("/update") // http://localhost:1234/products/update
	public Product updateProduct(@RequestBody Product product) {
		logger.info("updated");
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:1234/products/delete/123
	public String deleteProduct(@PathVariable("id") int productId) {
		logger.info("deleted");
		return service.deleteProduct(productId);
	}

	@GetMapping("/getById/{id}") // http://localhost:1234/products/getById/123
	public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
		logger.info("product got by ID");
		return service.getProductById(productId);
	}

	@GetMapping("/getAll") // http://localhost:1234/products/getAll
	public List<Product> getAllProducts() {
		logger.info("get all product");
		return service.getAllProducts();
	}

	@GetMapping("/getBetween/{price1}/{price2}") // http://localhost:1234/products/getBetween/1000/2000
	public List<Product> getAllBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		logger.info("get the product between the price");
		return service.getAllProductsBetweenPrice(initialPrice, finalPrice);
	}

	@GetMapping("/getProductByCategory/{category}") // http://localhost:1234/products/getProductByCategory/toys
	public List<Product> getProductByCategory(@PathVariable("category") String category) {
		logger.info("get products by category");
		return service.getProductsByCategory(category);
	}

	@GetMapping("/getProductLessThan/{category}/{price}") // http://localhost:1234/products/getProductLessThan/category/price
	public List<Product> getProductsByCategoryAndPrice(@PathVariable("category") String category,
			@PathVariable("price") int price) {
		logger.info("get product less than the value");
		return service.getProductsByCategoryAndPrice(category, price);
	}
}
