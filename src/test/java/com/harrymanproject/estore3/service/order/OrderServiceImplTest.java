package com.harrymanproject.estore3.service.order;

import com.harrymanproject.estore3.data.exception.OrderException;
import com.harrymanproject.estore3.data.model.Order;
import com.harrymanproject.estore3.data.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService = new OrderServiceImpl();
    Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order();
    }

    @Test
    void saveOrderTest() throws OrderException{
        orderService.saveOrder(order);
        verify(orderRepository, times(1)).saveOrder(order);
    }

    @Test
    void updateOrderTest(){
        orderService.updateOrder(order);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void findOrderByIdTest(){
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));
        orderService.findOrderById(1);
        verify(orderRepository, times(1)).findById(1);
    }

    @Test
    void findAllOrdersTest(){
        when(orderRepository.findAll()).thenReturn(List.of(order));
        orderService.findAllOrders();
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void deleteOrderByIdTest(){
        orderService.deleteOrderById(1);
        verify(orderRepository, times(1)).deleteById(1);
    }
}