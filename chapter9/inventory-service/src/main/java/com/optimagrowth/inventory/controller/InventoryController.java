package com.optimagrowth.inventory.controller;

import com.optimagrowth.inventory.model.Inventory;
import com.optimagrowth.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "v1/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/{inventoryId}", method = RequestMethod.GET)
	public ResponseEntity<Inventory> getInventory(@PathVariable("inventoryId") String inventoryId) {
		Inventory inventory = inventoryService.getInventory(inventoryId);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Inventory>> getInventoryByName(@PathVariable("name") String name) {
		List<Inventory> inventory = inventoryService.getInventoryByName(name);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@PutMapping(value="/{inventoryId}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable("inventoryId") String inventoryId, @RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.updateInventory(inventoryId, inventory), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		return new ResponseEntity<>(inventoryService.createInventory(inventory), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{inventoryId}")
	public ResponseEntity<String> deleteInventory(@PathVariable("inventoryId") String inventoryId) {
		return new ResponseEntity<>(inventoryService.deleteInventory(inventoryId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/name/{name}")
	public ResponseEntity<String> deleteInventoryByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(inventoryService.deleteInventoryByName(name), HttpStatus.OK);
	}

}
