package com.optimagrowth.orders.service;

import com.optimagrowth.orders.config.ServiceConfig;
import com.optimagrowth.orders.model.Cart;
import com.optimagrowth.orders.model.Orders;
import com.optimagrowth.orders.repository.CartRepository;
import com.optimagrowth.orders.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrdersService {

	@Autowired
	MessageSource messages;

    @Autowired
    private OrdersRepository ordersRepository;

	@Autowired
	ServiceConfig config;
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

    public Orders getOrders(String ordersId) {
        Optional<Orders> orders = ordersRepository.findById(ordersId);
        Orders orders1 = orders.orElseThrow(() -> new IllegalArgumentException("Order Not Found"));
        return orders1.withComment(config.getExampleProperty());
    }

    public List<Orders> getOrdersByOrdersNumber(String ordersNumber) {
        return ordersRepository.findByOrdersNumber(ordersNumber);

    }

    public Orders updateOrders(String ordersId, Orders orders) {
        Orders ordersToUpdate = getOrders(ordersId);

        ordersToUpdate.setOrdersStatus(orders.getOrdersStatus());
        ordersToUpdate.setCustomerName(orders.getCustomerName());
        ordersToUpdate.setOrdersDate(orders.getOrdersDate());
        ordersToUpdate.setCartId(orders.getCartId());
        ordersRepository.save(ordersToUpdate);

        return ordersToUpdate.withComment(config.getExampleProperty());
    }

    public Orders createOrders(Orders orders) {
        ordersRepository.save(orders);

        return orders.withComment(config.getExampleProperty());
    }

    public String deleteOrders(String ordersId) {
        String responseMessage = null;
        ordersRepository.deleteById(ordersId);
        responseMessage = String.format("Orders with ID: %s Deleted Successfully", ordersId);
        return responseMessage;
    }

    public String deleteOrdersByOrdersNumber(String ordersNumber) {
        String responseMessage = null;
        ordersRepository.deleteByOrdersNumber(ordersNumber);
        responseMessage = String.format("Orders with order number: %s Deleted Successfully", ordersNumber);
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
