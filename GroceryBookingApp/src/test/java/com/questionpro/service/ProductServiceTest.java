package com.questionpro.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.questionpro.entity.Product;
import com.questionpro.exception.ProductNotFoundException;
import com.questionpro.repo.ProductRepo;

@SpringBootTest 
public class ProductServiceTest {
	
	@Mock
	private ProductRepo productRepo;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private Product mockProduct;
	
	@Mock
	private List<Product> allProducts;
	
	 private Product product;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Product product = new Product(1L, "Product name", "Product desc", 100.0, 1 , "String", "String", "String", "String", new Date(), 10.0, "String", new Date(), new Date(), "String");
        allProducts.add(mockProduct);
    }
	
	@Test
	void getAllProducts() {
		when(productRepo.findAll()).thenReturn(new ArrayList<Product>());
		allProducts = productService.getAllProducts();
		
		assertThat(allProducts).isNotNull();
		assertThat(allProducts).contains(product);
		
		assertThat(allProducts.get(0).getProductId()).isEqualTo(1L);
		assertThat(allProducts.get(0).getProductDescription()).isEqualTo("Desc");
		assertThat(allProducts.get(0).getProductPrice()).isEqualTo(100.0);
		assertThat(allProducts.get(0).getQuantityAvailabe()).isEqualTo(100);
		assertThat(allProducts.get(0).getCategory()).isEqualTo("Cat");
		assertThat(allProducts.get(0).getBrand()).isEqualTo("Brand");
		assertThat(allProducts.get(0).getUnit()).isEqualTo("Kg");
	}
	
	@Test
	void deleteProduct() {
		when(productService.getProduct(1L)).thenReturn(new Product());
		doNothing().when(productRepo).delete(product);
		
		verify(productRepo).delete(product);
	}
	
	@Test
	void getProduct() {
		when(productRepo.findById(1L)).thenReturn(Optional.empty());
		when(productRepo.findById(1L)).thenReturn(null).thenThrow(ProductNotFoundException.class);
		
		mockProduct = productService.getProduct(1L);
		assertThat(product).isNotNull();
		assertThat(product.getProductId()).isEqualTo(1L);
		assertThat(product.getProductDescription()).isEqualTo("Desc");
		assertThat(product.getProductPrice()).isEqualTo(100.0);
		assertThat(product.getQuantityAvailabe()).isEqualTo(100);
		assertThat(product.getCategory()).isEqualTo("Cat");
		assertThat(product.getBrand()).isEqualTo("Brand");
		assertThat(product.getUnit()).isEqualTo("Kg");
	}
	
	@Test
	void updateProduct() {
		when(productService.getProduct(1L)).thenReturn(new Product());
		
		mockProduct = productService.updateProduct(product);
		assertThat(mockProduct).isNotNull();
		assertThat(mockProduct.getProductId()).isEqualTo(1L);
		assertThat(mockProduct.getProductDescription()).isEqualTo("Desc");
		assertThat(mockProduct.getProductPrice()).isEqualTo(100.0);
		assertThat(mockProduct.getQuantityAvailabe()).isEqualTo(100);
		assertThat(mockProduct.getCategory()).isEqualTo("Cat");
		assertThat(mockProduct.getBrand()).isEqualTo("Brand");
		assertThat(mockProduct.getUnit()).isEqualTo("Kg");
	}
	
	@Test
	void manageInventory() {
		when(productRepo.existsById(1L)).thenReturn(true);
		when(productRepo.existsById(1L)).thenReturn(false).thenThrow(ProductNotFoundException.class);
		
		mockProduct = productService.manageInventory(1L, product);
		assertThat(mockProduct).isNotNull();
		assertThat(mockProduct.getProductId()).isEqualTo(1L);
		assertThat(mockProduct.getProductDescription()).isEqualTo("Desc");
		assertThat(mockProduct.getProductPrice()).isEqualTo(100.0);
		assertThat(mockProduct.getQuantityAvailabe()).isEqualTo(101);
		assertThat(mockProduct.getCategory()).isEqualTo("Cat");
		assertThat(mockProduct.getBrand()).isEqualTo("Brand");
		assertThat(mockProduct.getUnit()).isEqualTo("Kg");
	}
}
