package com.questionpro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionpro.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	
//	@Query("SELECT p FROM PRODUCT p WHERE p.productId IN : ids")
//	List<Product> findAllProductsByIds(@Param("ids") List<Integer> ids);

}
