package com.smarthack.sudo.controller;

import com.smarthack.sudo.dto.OrderDto;
import com.smarthack.sudo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{cnp}")
    List<OrderDto> orderDtoList(@PathVariable String cnp) {
        return orderService.getOrders(cnp);
    }
}
