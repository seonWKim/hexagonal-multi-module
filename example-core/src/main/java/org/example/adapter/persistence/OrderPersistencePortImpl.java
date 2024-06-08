package org.example.adapter.persistence;

import java.sql.PreparedStatement;
import java.util.List;

import org.example.adapter.persistence.entity.mapper.OrderJpaEntityMapper;
import org.example.adapter.persistence.jpa.OrderJpaRepository;
import org.example.application.port.out.OrderPersistencePort;
import org.example.domain.order.CompletedOrderHistory;
import org.example.domain.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderPersistencePortImpl implements OrderPersistencePort {
    private final OrderJpaRepository orderJpaRepository;
    private final OrderJpaEntityMapper mapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Order findById(Long id) {
        return mapper.toDomain(orderJpaRepository.findById(id).orElseThrow());
    }

    @Override
    public List<Order> findCompletedOrders(Long lastId, int size) {
        return orderJpaRepository.findCompletedOrders(lastId, Pageable.ofSize(size));
    }

    @Override
    public Long save(Order order) {
        var entity = mapper.toJpaEntity(order);
        return orderJpaRepository.save(entity).getId();
    }

    @Override
    public void saveAll(List<CompletedOrderHistory> completedOrderHistories) {
        String sql = """
                    INSERT INTO completed_order_histories (order_id, member_id, name, price) 
                    VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.batchUpdate(sql, completedOrderHistories, completedOrderHistories.size(),
                                 (PreparedStatement ps, CompletedOrderHistory argument) -> {
                                     ps.setLong(1, argument.getOrderId());
                                     ps.setLong(2, argument.getMemberId());
                                     ps.setString(3, argument.getName());
                                     ps.setInt(4, argument.getPrice());
                                 });
    }

    @Override
    public List<Order> findByMemberId(Long memberId) {
        return orderJpaRepository.findByMemberId(memberId);
    }

    @Override
    public void delete(Long id) {
        orderJpaRepository.deleteById(id);
    }
}
