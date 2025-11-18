package com.optimagrowth.orders.controller;

import com.optimagrowth.orders.model.Orders;
import com.optimagrowth.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "v1/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "/{ordersId}", method = RequestMethod.GET)
	public ResponseEntity<Orders> getOrders(@PathVariable("ordersId") String ordersId) {
		Orders orders = ordersService.getOrders(ordersId);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@RequestMapping(value = "/ordersNumber/{ordersNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> getOrderByOrdersNumber(@PathVariable("ordersNumber") String ordersNumber) {
		List<Orders> orders = ordersService.getOrdersByOrdersNumber(ordersNumber);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@PutMapping(value="/{ordersId}")
	public ResponseEntity<Orders> updateOrders(@PathVariable("ordersId") String ordersId, @RequestBody Orders orders) {
		return new ResponseEntity<>(ordersService.updateOrders(ordersId, orders), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
		return new ResponseEntity<>(ordersService.createOrders(orders), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{ordersId}")
	public ResponseEntity<String> deleteOrders(@PathVariable("ordersId") String ordersId) {
		return new ResponseEntity<>(ordersService.deleteOrders(ordersId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/ordersNumber/{ordersNumber}")
	public ResponseEntity<String> deleteOrdersByOrderNumber(@PathVariable("ordersNumber") String ordersNumber) {
		return new ResponseEntity<>(ordersService.deleteOrdersByOrdersNumber(ordersNumber), HttpStatus.OK);
	}

}
