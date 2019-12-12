package com.example.springbootrest.controller;

import com.example.springbootrest.enitities.Order;
import com.example.springbootrest.enitities.User;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.repositories.OrderRepository;
import com.example.springbootrest.repositories.UserReporisotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@Validated
@RequestMapping(value = "/users")
public class OrderController {

    final private OrderRepository orderRepository;
    final private UserReporisotry userReporisotry;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserReporisotry userReporisotry) {
        this.orderRepository = orderRepository;
        this.userReporisotry = userReporisotry;
    }

    @GetMapping("/{userid}/orders")
    public List<Order> getUserOrders(@PathVariable Long userid) throws UserNotFoundException{
        Optional<User> usr = userReporisotry.findById(userid);
        if (!usr.isPresent()){
            throw new UserNotFoundException("not found");
        }
        return usr.get().getOrders();
    }

    @PostMapping("/{userid}/orders")
    public Order createorder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {

        Optional<User> usr = userReporisotry.findById(userid);
        if (!usr.isPresent()){
            throw new UserNotFoundException("not found");
        }

        User user = usr.get();
        order.setUser(user);

        return orderRepository.save(order);
    }
}
