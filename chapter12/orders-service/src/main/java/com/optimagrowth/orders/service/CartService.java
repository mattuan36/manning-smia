package com.optimagrowth.orders.service;

import java.util.*;

import com.optimagrowth.orders.model.Cart;
import com.optimagrowth.orders.repository.CartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.orders.config.ServiceConfig;

@Service
public class CartService {

	@Autowired
	MessageSource messages;

    @Autowired
    private CartRepository cartRepository;

	@Autowired
	ServiceConfig config;
	
	private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    public Cart getCart(String cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        return cart.orElseThrow(() -> new IllegalArgumentException("Cart Not Found"));
    }

    public Cart updateCart(String cartId, Cart cart) {
        Cart cartToUpdate = getCart(cartId);

        cartToUpdate.setItems(cart.getItems());
        cartRepository.save(cartToUpdate);

        return cartToUpdate;
    }

    public Cart createCart(Cart cart) {
        cartRepository.save(cart);

        return cart;
    }

    public String deleteCart(String cartId) {
        String responseMessage = null;
        cartRepository.deleteById(cartId);
        responseMessage = String.format("Cart with ID: %s Deleted Successfully", cartId);
        return responseMessage;
    }

    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
