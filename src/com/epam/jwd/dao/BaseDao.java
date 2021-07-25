package com.epam.jwd.dao;

import com.epam.jwd.domain.Food;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<T extends Food> {
    List<T> findAll() throws DaoException;

    T findById(int id) throws DaoException;

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }
}
