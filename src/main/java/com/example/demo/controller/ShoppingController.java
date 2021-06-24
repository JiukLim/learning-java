package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderItem;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ShoppingController {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;


    @GetMapping("/shopping")
    public void test() {
//        Member member = Member.builder()
//                              .name("jiuk")
//                              .city("seoul")
//                              .street("abc street")
//                              .zipCode("123-456")
//                              .build();
//        memberRepository.save(member);

        Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
        Order order = Order.builder()
                           .orderDate(LocalDateTime.now())
                           .status(Order.OrderStatus.ORDER)
                           .member(member)
                           .build();
        orderRepository.save(order);
    }

    @GetMapping("/members/{memberId}")
    public Member getMember(@PathVariable Long memberId) {
        Member member = memberRepository.findById(memberId)
                                        .orElseThrow(RuntimeException::new);
        return member;
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        return order;
    }

    @PostMapping("/order-items")
    public OrderItem orderItem() {
        Order order = orderRepository.findById(1L).orElseThrow(RuntimeException::new);
        Item item = itemRepository.findById(1L).orElseThrow(RuntimeException::new);
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(700);
        orderItem.setCount(5);
        orderItem.setOrder(order);
        orderItem.setItem(item);
        return orderItemRepository.save(orderItem);
    }

    @PostMapping("/items")
    public Item item() {
        Item item = new Item();
        item.setName("gold");
        item.setPrice(1000);
        item.setStockQuantity(500);
        return itemRepository.save(item);
    }
}
