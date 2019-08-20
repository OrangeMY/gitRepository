package com.imooc.os.dao.Impl;

import com.imooc.os.dao.OrderDao;
import com.imooc.os.entity.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void insert(Order o) {
        String sql = "insert into orders values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, o.getId(), o.getProductId(), o.getNumber(), o.getPrice(),
                o.getCreateTime(), o.getSendTime(), o.getConfirmTime(), o.getConsignee(),
                o.getConsigneePhone(), o.getConsigneeAddress(), o.getStatus());
    }

    public void update(Order o) {
        String sql = "update orders set send_time = ?, confirm_time = ?, consignee = ?, " +
                "consignee_phone = ?, consignee_address = ? where id = ?";
        jdbcTemplate.update(sql, o.getSendTime(), o.getConfirmTime(), o.getConsignee(),
                o.getConsigneePhone(), o.getConsigneeAddress(), o.getId());
    }

    public void delete(String id) {
        String sql = "delete from orders where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Order select(String id) {
        String sql = "select * from order where id = ?";
        return (Order) jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
    }

    public List<Order> select() {
        String sql = "select * from orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    private class OrderRowMapper implements RowMapper {

        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setProductId(resultSet.getString("products_id"));
            order.setNumber(resultSet.getInt("number"));
            order.setPrice(resultSet.getDouble("price"));
            order.setCreateTime(resultSet.getDate("create_time"));
            order.setSendTime(resultSet.getDate("send_time"));
            order.setConfirmTime(resultSet.getDate("confirm_time"));
            order.setConsignee(resultSet.getString("consignee"));
            order.setConsigneePhone(resultSet.getString("consignee_phone"));
            order.setConsigneeAddress(resultSet.getString("consignee_address"));
            order.setStatus(resultSet.getString("status"));
            return order;
        }
    }
}


