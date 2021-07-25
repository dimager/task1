

package com.epam.jwd.dao.impl;

import com.epam.jwd.dao.DaoException;
import com.epam.jwd.dao.MySqlDataSourceFactory;
import com.epam.jwd.dao.SaladDressingDao;
import com.epam.jwd.domain.SaladDressing;
import com.epam.jwd.domain.SaladDressingTypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SaladDressingDaoImpl implements SaladDressingDao {
    private static final String SQL_SELECT_ALL_SALADDRESSINGS = "SELECT * FROM food.saladdressing";
    private static final String SQL_SELECT_SALADDRESSING_BY_TYPE = "SELECT * FROM food.saladdressing WHERE type=?";
    private static final String SQL_SELECT_SALADDRESSING_BY_ID = "SELECT * FROM food.saladdressing WHERE id=?";

    public SaladDressingDaoImpl() {

    }

    public List<SaladDressing> findAll() throws DaoException {
        List<SaladDressing> saladDressings = new ArrayList();
        Connection connection = null;
        Statement statement = null;

        try {
          //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "admin", "!Pa$$w0rd");
            connection = MySqlDataSourceFactory.createMysqlDataSource().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_SALADDRESSINGS);

            while(resultSet.next()) {
                SaladDressing saladDressing = new SaladDressing();
                saladDressing.setId(resultSet.getInt(1));
                saladDressing.setName(resultSet.getString(2));
                saladDressing.setSaladDressingTypes(SaladDressingTypes.valueOf(resultSet.getString(3).toUpperCase(Locale.ROOT)));
                saladDressing.setProteins(resultSet.getDouble(4));
                saladDressing.setFats(resultSet.getDouble(5));
                saladDressing.setCarbs(resultSet.getDouble(6));
                saladDressings.add(saladDressing);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }

        return saladDressings;
    }

    public SaladDressing findById(int id) throws DaoException {
        SaladDressing saladDressing = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "admin", "!Pa$$w0rd");
            connection = MySqlDataSourceFactory.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_SALADDRESSING_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                saladDressing = new SaladDressing();
                saladDressing.setId(resultSet.getInt(1));
                saladDressing.setName(resultSet.getString(2));
                saladDressing.setSaladDressingTypes(SaladDressingTypes.valueOf(resultSet.getString(3).toUpperCase(Locale.ROOT)));
                saladDressing.setProteins(resultSet.getDouble(4));
                saladDressing.setFats(resultSet.getDouble(5));
                saladDressing.setCarbs(resultSet.getDouble(6));
                saladDressing.setEnergy(resultSet.getDouble(7));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            close(connection);
        }

        return saladDressing;
    }

    public List<SaladDressing> findByType(SaladDressingTypes saladDressingType) {
        List<SaladDressing> saladDressings = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "admin", "!Pa$$w0rd");
            connection = MySqlDataSourceFactory.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_SALADDRESSING_BY_TYPE);
            preparedStatement.setString(1, saladDressingType.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                SaladDressing saladDressing = new SaladDressing();
                saladDressing.setId(resultSet.getInt(1));
                saladDressing.setName(resultSet.getString(2));
                saladDressing.setSaladDressingTypes(SaladDressingTypes.valueOf(resultSet.getString(3).toUpperCase(Locale.ROOT)));
                saladDressing.setProteins(resultSet.getDouble(4));
                saladDressing.setFats(resultSet.getDouble(5));
                saladDressing.setCarbs(resultSet.getDouble(6));
                saladDressing.setEnergy(resultSet.getDouble(7));
                saladDressings.add(saladDressing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }

        return saladDressings;
    }
}
