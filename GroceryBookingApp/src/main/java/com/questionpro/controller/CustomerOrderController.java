package com.questionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.entity.Product;
import com.questionpro.order.OrderRequest;
import com.questionpro.order.OrderResponse;
import com.questionpro.service.OrderService;
import com.questionpro.service.ProductService;


@RestController
@RequestMapping("/user")
public class CustomerOrderController {
	
	//order service dependency
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
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
	
	@PostMapping("/book-grocery")
	public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderrequest) {
		OrderResponse saveOrder = orderService.saveOrder(orderrequest);
		return ResponseEntity.ok(saveOrder);
	}
	
	@GetMapping("/view-order")
	public ResponseEntity<OrderResponse> getOrder(@RequestParam Integer orderid) {
		OrderResponse order = orderService.getOrder(orderid);
		return ResponseEntity.ok(order);
	}

}
