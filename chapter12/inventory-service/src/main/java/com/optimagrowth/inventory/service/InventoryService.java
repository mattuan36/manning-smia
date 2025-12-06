package com.optimagrowth.inventory.service;

import java.util.*;
import java.util.concurrent.TimeoutException;

import com.optimagrowth.inventory.model.Inventory;
import com.optimagrowth.inventory.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.inventory.config.ServiceConfig;
import com.optimagrowth.inventory.utils.UserContextHolder;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class InventoryService {

	@Autowired
	MessageSource messages;

    @Autowired
    private InventoryRepository inventoryRepository;

	@Autowired
	ServiceConfig config;
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    public Inventory getInventory(String inventoryId) {
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
        Inventory inventory1 = inventory.orElseThrow(() -> new IllegalArgumentException("Inventory Not Found"));
        return inventory1.withComment(config.getExampleProperty());
    }

    public List<Inventory> getInventoryByName(String name) {
        return inventoryRepository.findByName(name);

    }

    public Inventory updateInventory(String InventoryId, Inventory inventory) {
        Inventory inventoryToUpdate = getInventory(InventoryId);

        inventoryToUpdate.setName(inventory.getName());
        inventoryToUpdate.setDescription(inventory.getDescription());
        inventoryToUpdate.setCategory(inventory.getCategory());
        inventoryToUpdate.setStock(inventory.getStock());
        inventoryRepository.save(inventoryToUpdate);

        return inventoryToUpdate.withComment(config.getExampleProperty());
    }

    public Inventory createInventory(Inventory inventory) {
        inventoryRepository.save(inventory);

        return inventory.withComment(config.getExampleProperty());
    }

    public String deleteInventory(String inventoryId) {
        String responseMessage = null;
        inventoryRepository.deleteById(inventoryId);
        responseMessage = String.format("Inventory item: %s Deleted Successfully", inventoryId);
        return responseMessage;
    }

    public String deleteInventoryByName(String name) {
        String responseMessage = null;
        inventoryRepository.deleteByName(name);
        responseMessage = String.format("Inventory item: %s Deleted Successfully", name);
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
