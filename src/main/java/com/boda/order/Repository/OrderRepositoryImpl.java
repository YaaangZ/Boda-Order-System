package com.boda.order.Repository;

import com.boda.order.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO order_info (product_name, product_id, product_specification, product_quantity, branch_name, school_name, order_date, create_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getProductName(), order.getProductId(), order.getProductSpecification(),
                order.getProductQuantity(), order.getBranchName(), order.getSchoolName(), order.getOrderDate(),
                new Date());
    }

    @Override
    public Order findByOrderId(Long orderId) {
        String sql = "SELECT * FROM order_info WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new OrderRowMapper());
    }

    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductId(rs.getString("product_id"));
            order.setProductSpecification(rs.getString("product_specification"));
            order.setProductQuantity(rs.getInt("product_quantity"));
            order.setBranchName(rs.getString("branch_name"));
            order.setSchoolName(rs.getString("school_name"));
            Date date = rs.getDate("order_date");
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            order.setOrderDate(localDate);
            Timestamp timestamp = rs.getTimestamp("create_time");
            LocalDateTime localDateTime = timestamp.toLocalDateTime();
            order.setCreateTime(localDateTime);
            return order;
        }
    }
}
