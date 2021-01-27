package com.danny.demo.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class UserService1 {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public User getUserById(long id) {
        return jdbcTemplate.execute(new ConnectionCallback<User>() {
            @Override
            public User doInConnection(Connection connection) throws SQLException, DataAccessException {
                try (var ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?")){
                    ps.setObject(1,id);
                    try (var result = ps.executeQuery()) {
                        if (result.next()) {
                            return new User(
                                    result.getLong("id"),
                                    result.getString("emial"),
                                    result.getString("password"),
                                    result.getString("name")
                                    );
                        }
                        throw new RuntimeException("user not found by id");
                    }
                }
            }
        });
    }

}
