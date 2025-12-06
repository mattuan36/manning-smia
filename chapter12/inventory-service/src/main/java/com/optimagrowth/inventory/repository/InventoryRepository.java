package com.optimagrowth.inventory.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimagrowth.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,String>  {
    public List<Inventory> findByName(String name);

    public void deleteByName(String name);
}
