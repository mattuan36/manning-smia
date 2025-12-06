package com.optimagrowth.orders.repository;

import com.optimagrowth.orders.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,String>  {
    public List<Orders> findByOrdersNumber(String ordersNumber);

    public void deleteByOrdersNumber(String ordersNumber);
}