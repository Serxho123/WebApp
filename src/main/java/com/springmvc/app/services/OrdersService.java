package com.springmvc.app.services;

import com.springmvc.app.domain.Orders;
import com.springmvc.app.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAllOrdersRecords() {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersList;
    }

    public void saveOrderIntoDB(Orders order) {
        this.ordersRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        boolean exists = ordersRepository.existsById(orderId);
        if (!exists) {
            throw new IllegalStateException("order with id" + orderId + "does not exist");
        }
        ordersRepository.deleteById(orderId);
    }

    public Orders getOrderById(Long id) {
        Optional<Orders> orderDetail = ordersRepository.findById(id);
        Orders order = null;
        if (orderDetail.isPresent()) {
            order = orderDetail.get();
        } else {
            throw new RuntimeException("Order not found for id::" + id);
        }
        return order;
    }
}



