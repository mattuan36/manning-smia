package com.optimagrowth.inventory.repository;

import com.optimagrowth.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,String>  {
    public List<Inventory> findByName(String name);

    public void deleteByName(String name);
}
