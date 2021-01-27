package com.danny.demo.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;

@Component
public class  UserService1 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User register(String email, String password, String name) {
        KeyHolder holder = new GeneratedKeyHolder();
        if (1 != jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                var ps = connection.prepareStatement("INSERT INTO users(email,password,name) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1,email);
                ps.setObject(2,password);
                ps.setObject(3,name);
                return ps;
            }
        },holder)){
          throw new RuntimeException("Insert failed");
        }
        return new User(holder.getKey().longValue(),email,password,name);
    }

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
                                    result.getString("email"),
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


    public User getUserByName(String name){
        return jdbcTemplate.execute("SELECT * FROM users WHERE name = ?", new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setObject(1,name);
                try (var rs = preparedStatement.executeQuery())  {
                    if (rs.next()) {
                        return new User(
                                rs.getLong("id"),
                                rs.getString("email"),
                                rs.getString("password"),
                                rs.getString("name")
                        );
                    }
                    throw new RuntimeException("user not found by name");
                }
            }
        });
    }

    public long getUsers(){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", null, (ResultSet rs, int rowNum) -> {
            return rs.getLong(1);
        });
    }

    public List<User> getUsers(int pageIndex) {
        int limit = 100;
        int offset = limit * (pageIndex - 1);
        return jdbcTemplate.query("SELECT * FROM users LIMIT ? OFFSET ?",new Object[] { limit, offset},
                new BeanPropertyRowMapper<>(User.class));
    }
}
