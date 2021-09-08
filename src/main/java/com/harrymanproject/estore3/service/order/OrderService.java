package com.harrymanproject.estore3.service.order;

import com.harrymanproject.estore3.data.exception.OrderException;
import com.harrymanproject.estore3.data.model.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order) throws OrderException;
    void updateOrder(Order order);
    Order findOrderById(Integer id);
    List<Order> findAllOrders();
    void deleteOrderById(Integer id);
}
