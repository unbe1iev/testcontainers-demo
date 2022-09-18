package com.unbe1iev.testcontainersdemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDao {

    final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query(
                "SELECT id, firstName, lastName FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"))
        );
    }
}
