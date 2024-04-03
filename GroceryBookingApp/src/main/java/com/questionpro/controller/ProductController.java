package com.questionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.entity.Product;
import com.questionpro.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class); 

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		try {
			Product saveProduct = productService.saveProduct(product);
			LOGGER.info("Add Grocery Product::{}",product);
			return new ResponseEntity<Product>(saveProduct, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		try {
			List<Product> products = new ArrayList<>();
			productService.getAllProducts().forEach(products::add);
			if(products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/product/{product-id}")	
	public ResponseEntity<Product> getProduct(@PathVariable("product-id") Long id) {
		 Product product = productService.getProduct(id);
		 if(product == null) {
			 return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		 }else {
			 return new ResponseEntity<Product>(product, HttpStatus.OK);
		 }
	}
	
	@DeleteMapping("/remove-product")
	public ResponseEntity<HttpStatus> removeProduct(@RequestParam Long id) {
		try {
			productService.deleteProduct(id);
			LOGGER.info("Remove Grocery Product based upon the item id::{}",id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update-product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		try {
			Product savedProduct = productService.updateProduct(product);
			LOGGER.info("Update Grocery Product::{}",savedProduct);
			return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/manageGrocery-items/{productId}")
	public ResponseEntity<Product> manageInventory(@PathVariable Long productId, @RequestBody Product product) {
		LOGGER.info("Manage Inventory Product::{}",product);
        return ResponseEntity.ok(productService.manageInventory(productId, product));
    }
	
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error)->{
//			String fieldName = ((FieldError)error).getField();
//			String errorMessage = error.getDefaultMessage();
//			errors.put(fieldName, errorMessage);
//		});
//		return errors;
//	}

}
