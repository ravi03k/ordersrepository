package com.ravi.SpringBootOrderServiceApplication.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ravi.SpringBootOrderServiceApplication.model.Orders;
import com.ravi.SpringBootOrderServiceApplication.model.OrdersNotFoundException;
import com.ravi.SpringBootOrderServiceApplication.repositories.OrderRepository;

/**
 * @author Ravi
 *
 */

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * Find all orders
	 * 
	 * @return Orders
	 */
	@GetMapping("/orders")
	public List<Orders> findAllOrders() {
		return orderRepository.findAll();
	}

	/**
	 * Find an order
	 * 
	 * @param id
	 * @return Order
	 */
	@GetMapping("/orders/{id}")
	public Orders getOrder(@PathVariable long id) {
		Optional<Orders> order = orderRepository.findById(id);
		if (!order.isPresent())
			throw new OrdersNotFoundException("id-" + id);
		return order.get();
	}

	/**
	 * Delete an order
	 * 
	 * @param id
	 */
	@DeleteMapping("/orders/{id}")
	public void deleteStudent(@PathVariable long id) {
		orderRepository.deleteById(id);
	}

	/**
	 * Create an order
	 * 
	 * @param orders
	 * @return url with id
	 */
	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@RequestBody Orders orders) {
		Orders savedOrder = orderRepository.save(orders);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrder.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	/**
	 * Update an order using id
	 * 
	 * @param orders
	 * @param id
	 * @return
	 */
	@PutMapping("/orders/{id}")
	public ResponseEntity<Object> updateOrder(@RequestBody Orders orders, @PathVariable long id) {
		Optional<Orders> orderOptional = orderRepository.findById(id);
		if (!orderOptional.isPresent())
			return ResponseEntity.notFound().build();
		Orders dbOrder = orderOptional.get();
		if (orders.getItem() != null)
			dbOrder.setItem(orders.getItem());
		Long orderPrice = orders.getPrice();
		if (orderPrice != null)
			dbOrder.setPrice(orders.getPrice());
		orderRepository.save(dbOrder);
		return ResponseEntity.noContent().build();
	}
}
