package com.questionpro.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.questionpro.entity.Order;
import com.questionpro.entity.Product;
import com.questionpro.exception.ProductNotFoundException;
import com.questionpro.order.OrderRequest;
import com.questionpro.order.OrderResponse;
import com.questionpro.repo.OrderRepo;
import com.questionpro.repo.ProductRepo;

@SpringBootTest
public class OrderServiceTest {

	@Mock
	private OrderRepo orderRepo;
	
	@Mock
	private ProductRepo productRepo;
	
	@InjectMocks
	private OrderService orderService;
	
	private Product product;
	private Order order;
	 public static List<Product> productList;
//	@Mock
//	private OrderRequest orderRequest;
//	@Mock
//	private OrderResponse orderResponse;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order(1, new Date(), Arrays.asList(product), 100.0, "COMPLETED", "NOTE"); 
        product = new Product(1L, "Product name", "Product desc", 100.0, 1 , "String", "String", "String", "String", new Date(), 10.0, "String", new Date(), new Date(), "String");
        productList = Stream.of(product).toList();
    }
	
	
	@Test
	void saveOrder(){
		
		//given
		OrderRequest orderRequest = new OrderRequest(new Long[]{1L}, "Notes");
		when(orderRepo.save(order)).thenReturn(order);
		when(productRepo.findAllById(Arrays.asList(1L))).thenReturn(productList);
		
		//when
		OrderResponse orderResponse = orderService.saveOrder(orderRequest);
		assertThat(orderResponse).isNotNull();
		assertThat(orderResponse.getOrderId()).isEqualTo(1L);
		assertThat(orderResponse.getProducts()).isNotNull();
		assertThat(orderResponse.getNote()).isEqualTo("NOTE");
		assertThat(orderResponse.getStaus()).isEqualTo("COMPLETED");
		assertThat(orderResponse.getTotalAmount()).isEqualTo(100.0);
	}
	
	@Test 
	void getOrder() {
		when(orderRepo.findById(1)).thenReturn(Optional.of(order));
		
		OrderResponse orderResponse = orderService.getOrder(1);
		assertThat(orderResponse).isNotNull();
		assertThat(orderResponse.getOrderId()).isEqualTo(1L);
		assertThat(orderResponse.getProducts()).isNotNull();
		assertThat(orderResponse.getNote()).isEqualTo("NOTE");
		assertThat(orderResponse.getStaus()).isEqualTo("COMPLETED");
		assertThat(orderResponse.getTotalAmount()).isEqualTo(100.0);
	}
	
	
}
