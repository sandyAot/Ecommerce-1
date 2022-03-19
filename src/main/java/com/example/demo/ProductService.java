package com.example.demo;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Range;
	import org.springframework.stereotype.Service;

	import com.example.demo.ProductDto;
	import reactor.core.publisher.Flux;
	import reactor.core.publisher.Mono;
	import com.example.demo.ProductRepository;
	import com.example.demo.AppUtils;

	@Service
	public class ProductService {
		@Autowired
	    private ProductRepository repository;

	//what is flux .what is method referance .why we use map
	    public Flux<ProductDto> getProducts(){
	        return repository.findAll().map(AppUtils::entityToDto);
	    }
	//what is mono
	    public Mono<ProductDto> getProduct(String id){
	        return repository.findById(id).map(AppUtils::entityToDto);
	    }

	    public Flux<ProductDto> getProductInRange(double min,double max){
	        return repository.findByPriceBetween(Range.closed(min,max));
	    }
	//when to use map and when flat map
	    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
	        System.out.println("service method called ...");
	      return  productDtoMono.map(AppUtils::dtoToEntity)
	                .flatMap(repository::insert)
	                .map(AppUtils::entityToDto);
	    }

	    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono,String id){
	       return repository.findById(id)
	                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity)
	                .doOnNext(e->e.setId(id)))
	                .flatMap(repository::save)
	                .map(AppUtils::entityToDto);

	    }

	    public Mono<Void> deleteProduct(String id){
	        return repository.deleteById(id);
	    }

	}


