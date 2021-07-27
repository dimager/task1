package com.epam.jwd.dao.impl;

import com.epam.jwd.dao.DaoException;
import com.epam.jwd.dao.SaladDressingDao;
import com.epam.jwd.domain.SaladDressing;
import com.epam.jwd.domain.SaladDressingType;
import com.epam.jwd.service.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SaladDressingDaoImpl implements SaladDressingDao {
    private static final String SQL_SELECT_ALL_SALADDRESSINGS = "SELECT * FROM food.saladdressing";
    private static final String SQL_SELECT_SALADDRESSING_BY_TYPE = "SELECT * FROM food.saladdressing WHERE type=?";
    private static final String SQL_SELECT_SALADDRESSING_BY_ID = "SELECT * FROM food.saladdressing WHERE id=?";

    public List<SaladDressing> findAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Dao.createMysqlDataSource().getConnection();
            statement = connection.createStatement();
            return Dao.getVegetableFromDatabaseToList(statement.executeQuery(SQL_SELECT_ALL_SALADDRESSINGS));
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public List<SaladDressing> findById(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Dao.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_SALADDRESSING_BY_ID);
            preparedStatement.setInt(1, id);
            return Dao.getVegetableFromDatabaseToList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public List<SaladDressing> findByType(SaladDressingType saladDressingType) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Dao.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_SALADDRESSING_BY_TYPE);
            preparedStatement.setString(1, saladDressingType.toString());
            return Dao.getVegetableFromDatabaseToList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }
}
