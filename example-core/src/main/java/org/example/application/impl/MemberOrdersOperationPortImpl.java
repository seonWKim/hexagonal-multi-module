package org.example.application.impl;

import java.util.List;

import org.example.application.port.in.MemberOrdersOperationPort;
import org.example.application.port.in.MembersOperationPort;
import org.example.application.port.in.OrdersOperationPort;
import org.example.application.port.in.command.OrderCompleteCommand;
import org.example.application.port.in.command.OrderRegisterCommand;
import org.example.domain.member.Member;
import org.example.domain.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class MemberOrdersOperationPortImpl implements MemberOrdersOperationPort {

    private final MembersOperationPort membersOperationPort;
    private final OrdersOperationPort ordersOperationPort;

    @Override
    @Transactional(readOnly = true)
    public List<Order> findOrders(Long memberId) {
        Member member = membersOperationPort.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        return ordersOperationPort.findOrdersByMemberId(memberId);
    }

    @Override
    @Transactional
    public Long order(Long memberId, OrderRegisterCommand command) {
        Member member = membersOperationPort.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        return ordersOperationPort.registerOrder(command);
    }

    @Override
    @Transactional
    public void completeOrder(Long memberId, Long orderId) {
        if (membersOperationPort.findMemberBy(memberId) == null ||
            ordersOperationPort.findById(orderId) == null) {
            throw new IllegalArgumentException("회원 정보가 또는 주문 정보가 존재하지 않습니다.");
        }

        ordersOperationPort.completeOrder(new OrderCompleteCommand(orderId));
    }

    @Override
    @Transactional
    public void cancel(Long memberId, Long orderId) {
        Member member = membersOperationPort.findMemberBy(memberId);
        if (member == null) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        Order order = ordersOperationPort.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("상품 정보가 존재하지 않습니다.");
        }

        ordersOperationPort.deleteOrderById(orderId);
    }
}
