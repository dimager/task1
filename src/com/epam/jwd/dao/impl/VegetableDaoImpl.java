package com.epam.jwd.dao.impl;

import com.epam.jwd.dao.DaoException;
import com.epam.jwd.dao.VegetableDao;
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableType;
import com.epam.jwd.service.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VegetableDaoImpl implements VegetableDao {
    private static final String SQL_SELECT_ALL_VEGETABLES = "SELECT name,type,proteins,fats,carbs,energy,fibre,id FROM vegetables";
    private static final String SQL_SELECT_VEGETABLE_BY_TYPE = "SELECT name,type,proteins,fats,carbs,energy,fibre,id from vegetables WHERE type=?";
    private static final String SQL_SELECT_VEGETABLE_BY_ID = "SELECT name,type,proteins,fats,carbs,energy,fibre,id from vegetables WHERE id=?";

    public List<Vegetable> findAll() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Dao.createMysqlDataSource().getConnection();
            statement = connection.createStatement();
            return Dao.getSaladDressingFromDatabaseToList(statement.executeQuery(SQL_SELECT_ALL_VEGETABLES));
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }
    }

    public List<Vegetable> findById(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Dao.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_VEGETABLE_BY_ID);
            preparedStatement.setInt(1, id);
            return Dao.getSaladDressingFromDatabaseToList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public List<Vegetable> findByType(VegetableType vegetableType) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = Dao.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_VEGETABLE_BY_TYPE);
            preparedStatement.setString(1, vegetableType.toString());
            return Dao.getSaladDressingFromDatabaseToList(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            this.close(preparedStatement);
            this.close(connection);
        }
    }
}
