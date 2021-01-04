package com.devsuperior.dsdelivery.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.DTO.ProductDTO;
import com.devsuperior.dsdelivery.Repositories.ProductRepository;
import com.devsuperior.dsdelivery.entities.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Transactional(readOnly = true)
	public List<ProductDTO>findAll(){
		List<Product> list = repo.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		
	}
}
