package org.example.application.impl;

import java.util.List;

import org.example.application.OrderFacade;
import org.example.domain.member.Member;
import org.example.domain.member.MemberService;
import org.example.domain.order.Order;
import org.example.domain.order.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderFacadeImpl implements OrderFacade {

    private final MemberService memberService;
    private final OrderService orderService;

    @Override
    @Transactional(readOnly = true)
    public List<Order> findOrders(Long memberId) {
        Member member = memberService.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        return orderService.findOrdersByMemberId(memberId);
    }

    @Override
    @Transactional
    public Long order(Long memberId, Order order) {
        Member member = memberService.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        return orderService.registerOrder(order);
    }

    @Override
    @Transactional
    public void completeOrder(Long memberId, Long orderId) {
        Member member = memberService.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        Order order = orderService.findById(orderId);
        orderService.completeOrder(order);
    }

    @Override
    @Transactional
    public void cancel(Long memberId, Long orderId) {
        Member member = memberService.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        Order order = orderService.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("상품 정보가 존재하지 않습니다.");
        }

        orderService.deleteOrderById(orderId);
    }
}
