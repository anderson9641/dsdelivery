package com.devsuperior.dsdelivery.Services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.DTO.OrderDTO;
import com.devsuperior.dsdelivery.DTO.ProductDTO;
import com.devsuperior.dsdelivery.Repositories.OrderRepository;
import com.devsuperior.dsdelivery.Repositories.ProductRepository;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.OrderStatus;
import com.devsuperior.dsdelivery.entities.Product;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO>findAll(){
		List<Order> list = repo.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		for(ProductDTO p: dto.getProducts()) {
			Product product = productRepository.getOne(p.getId() );
			order.getProdutcs().add(product);
		}
		order = repo.save(order);
		return new OrderDTO(order);
	}	
	
}
