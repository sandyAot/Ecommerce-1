package com.example.demo;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ProductDto;
import com.example.demo.Product;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

	Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);

}
