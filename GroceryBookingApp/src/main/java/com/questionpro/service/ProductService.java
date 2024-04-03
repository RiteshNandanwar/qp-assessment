package com.questionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.entity.Product;
import com.questionpro.exception.ProductNotFoundException;
import com.questionpro.repo.ProductRepo;

import jakarta.persistence.EntityManager;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product saveProduct(Product product) {
		Product savedproduct = productRepo.save(product);
		return savedproduct;
	}
	
	public void deleteProduct(Long id) {
		Product foundProduct = getProduct(id);
		productRepo.delete(foundProduct);
	}

	public Product getProduct(Long id) {
		Product foundProduct = productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found with ID : "+id));
		return foundProduct;
	}

	public Product updateProduct(Product productToSave) {
		Product product = getProduct(productToSave.getProductId());
		product.setProductName(productToSave.getProductName());
		productRepo.save(product);
		return product;
	}

	public Product manageInventory(Long productId, Product productRequest) {
        if (productRepo.existsById(productId)) {
        	Product product = productRepo.getOne(productId);
            int updatedQuantity = product.getQuantityAvailabe() + productRequest.getQuantityAvailabe();
            product.setQuantityAvailabe(updatedQuantity);
            return productRepo.save(product);
        } else {
            throw new ProductNotFoundException("Product not found with id: " + productId);
        }
    }

}
