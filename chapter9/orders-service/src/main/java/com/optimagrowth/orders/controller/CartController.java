package com.optimagrowth.orders.controller;

import com.optimagrowth.orders.model.Cart;
import com.optimagrowth.orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public ResponseEntity<Cart> getOrder(@PathVariable("cartId") String cartId) {
		Cart cart = cartService.getCart(cartId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@PutMapping(value="/{cartId}")
	public ResponseEntity<Cart> updateOrder(@PathVariable("cartId") String cartId, @RequestBody Cart cart) {
		return new ResponseEntity<>(cartService.updateCart(cartId, cart), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(cartService.createCart(cart), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{cartId}")
	public ResponseEntity<String> deleteInventory(@PathVariable("cartId") String cartId) {
		return new ResponseEntity<>(cartService.deleteCart(cartId), HttpStatus.OK);
	}
}