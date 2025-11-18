package com.optimagrowth.orders.repository;

import com.optimagrowth.orders.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,String>  {

}
