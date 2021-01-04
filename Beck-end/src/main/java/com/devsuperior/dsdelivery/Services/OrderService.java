package com.devsuperior.dsdelivery.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivery.DTO.OrderDTO;
import com.devsuperior.dsdelivery.Repositories.OrderRepository;
import com.devsuperior.dsdelivery.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Transactional(readOnly = true)
	public List<OrderDTO>findAll(){
		List<Order> list = repo.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
}
