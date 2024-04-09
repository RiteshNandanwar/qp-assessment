package com.questionpro.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.controller.ProductController;
import com.questionpro.entity.Order;
import com.questionpro.entity.Product;
import com.questionpro.exception.OrderNotFoundException;
import com.questionpro.exception.ProductNotFoundException;
import com.questionpro.order.OrderRequest;
import com.questionpro.order.OrderResponse;
import com.questionpro.repo.OrderRepo;
import com.questionpro.repo.ProductRepo;

@Service
public class OrderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@SuppressWarnings("unchecked")
	public OrderResponse saveOrder(OrderRequest request) {
		LOGGER.info("OrderService::Product IDs in request : "+Arrays.toString(request.getItems()));
		Order order = new Order();
		OrderResponse response = null;
		List<Product> products = null;
		if(request.getItems() != null) {
			products = productRepo.findAllById(Arrays.asList(request.getItems()));
		}
		if((products == null || products.isEmpty()) && products.size() != request.getItems().length) {
			throw new ProductNotFoundException("Products not found with IDs : "+Arrays.toString(request.getItems()));
		} else {
			order.setTotalAmount(calculateAmount(products, request.getItems()));
			order.setOrderDate(new Date());
			order.setProducts(products);
			order.setNotes(request.getNotes());
			order.setStatus("COMPLETE");
			Order save = orderRepo.save(order);
			response = prepareOrderResponse(save);
		}
		return response;
	}
	
	private OrderResponse prepareOrderResponse(Order order) {
		OrderResponse response = new OrderResponse();
		response.setProducts(order.getProducts());
		response.setNote(order.getNotes());
		response.setOrderDate(order.getOrderDate());
		response.setStaus(order.getStatus());
		response.setOrderId(order.getOrderId());
		response.setTotalAmount(order.getTotalAmount());
		return response;
	}

	private Double calculateAmount(List<Product> products, Long[] items) {
		Double totalAmount = 0.0;
		if(products == null || products.isEmpty()) {
				throw new ProductNotFoundException("Products not found with IDs : "+Arrays.toString(items));
		}else {
			totalAmount = products.stream().mapToDouble(Product::getProductPrice).sum();		
		}
		return totalAmount;
	}

	public OrderResponse getOrder(Integer orderId) {
		Order order = null;
		if(orderId != null) {
			order = orderRepo.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order Not found with order Id: "+orderId));
		}
		
		OrderResponse orderResponse = prepareOrderResponse(order);
		return orderResponse;
	}
}
