package org.example.adapter.port.in.order;

import java.util.List;

import org.example.application.port.in.MemberOrdersOperationPort;
import org.example.application.port.in.command.OrderRegisterCommand;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final MemberOrdersOperationPort memberOrdersOperationPort;
    private final OrderMapper orderMapper;

    @GetMapping("/members/{memberId}/orders")
    public List<OrderResponse> findOrders(@PathVariable Long memberId) {
        return memberOrdersOperationPort.findOrders(memberId)
                                        .stream()
                                        .map(orderMapper::mapToOrderResponse)
                                        .toList();
    }

    @PostMapping("/members/{memberId}/orders")
    public Long createOrder(@PathVariable Long memberId, @RequestBody OrderRequest orderRequest) {
        final OrderRegisterCommand order = orderMapper.mapToOrderRegisterCommand(memberId, orderRequest);
        return memberOrdersOperationPort.order(memberId, order);
    }

    @PutMapping("/members/{memberId}/orders/{orderId}")
    public void completeOrder(@PathVariable Long memberId, @PathVariable Long orderId) {
        memberOrdersOperationPort.completeOrder(memberId, orderId);
    }

    @DeleteMapping("/members/{memberId}/orders/{orderId}")
    public void cancelOrder(@PathVariable Long memberId, @PathVariable Long orderId) {
        memberOrdersOperationPort.cancel(memberId, orderId);
    }
}
