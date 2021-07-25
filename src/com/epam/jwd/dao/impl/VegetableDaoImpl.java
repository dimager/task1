

package com.epam.jwd.dao.impl;

import com.epam.jwd.dao.DaoException;
import com.epam.jwd.dao.MySqlDataSourceFactory;
import com.epam.jwd.dao.VegetableDao;
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableTypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VegetableDaoImpl implements VegetableDao {
    private static final String SQL_SELECT_ALL_VEGETABLES = "SELECT name,type,proteins,fats,carbs,energy,fibre,id FROM vegetables";
    private static final String SQL_SELECT_VEGETABLE_BY_TYPE = "SELECT name,type,proteins,fats,carbs,energy,fibre,id from vegetables WHERE type=?";
    private static final String SQL_SELECT_VEGETABLE_BY_ID = "SELECT name,type,proteins,fats,carbs,energy,fibre,id from vegetables WHERE id=?";

    public List<Vegetable> findAll() throws DaoException {
        List<Vegetable> vegetables = new ArrayList();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "admin", "!Pa$$w0rd");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name,type,proteins,fats,carbs,energy,fibre,id FROM vegetables");

            while(resultSet.next()) {
                Vegetable vegetable = new Vegetable();
                vegetable.setId(resultSet.getInt(8));
                vegetable.setName(resultSet.getString(1));
                vegetable.setVegetableTypes(VegetableTypes.valueOf(resultSet.getString(2).toUpperCase(Locale.ROOT)));
                vegetable.setProteins(resultSet.getDouble(3));
                vegetable.setFats(resultSet.getDouble(4));
                vegetable.setCarbs(resultSet.getDouble(5));
                vegetable.setEnergy(resultSet.getDouble(6));
                vegetable.setFibre(resultSet.getDouble(7));
                vegetables.add(vegetable);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
        }

        return vegetables;
    }

    public Vegetable findById(int id) throws DaoException {
        Vegetable vegetable = new Vegetable();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "admin", "!Pa$$w0rd");
            connection = MySqlDataSourceFactory.createMysqlDataSource().getConnection();
            preparedStatement = connection.prepareStatement("SELECT name,type,proteins,fats,carbs,energy,fibre,id from vegetables WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                vegetable.setId(resultSet.getInt(8));
                vegetable.setName(resultSet.getString(1));
                vegetable.setVegetableTypes(VegetableTypes.valueOf(resultSet.getString(2).toUpperCase(Locale.ROOT)));
                vegetable.setProteins(resultSet.getDouble(3));
                vegetable.setFats(resultSet.getDouble(4));
                vegetable.setCarbs(resultSet.getDouble(5));
                vegetable.setEnergy(resultSet.getDouble(6));
                vegetable.setFibre(resultSet.getDouble(7));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
            close(connection);
        }

        return vegetable;
    }

    public List<Vegetable> findByType(VegetableTypes vegetableType) throws DaoException {
        List<Vegetable> vegetables = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", "admin", "!Pa$$w0rd");
            preparedStatement = connection.prepareStatement("SELECT name,type,proteins,fats,carbs,energy,fibre,id from vegetables WHERE type=?");
            preparedStatement.setString(1, vegetableType.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Vegetable vegetable = new Vegetable();
                vegetable.setId(resultSet.getInt(8));
                vegetable.setName(resultSet.getString(1));
                vegetable.setVegetableTypes(VegetableTypes.valueOf(resultSet.getString(2).toUpperCase(Locale.ROOT)));
                vegetable.setProteins(resultSet.getDouble(3));
                vegetable.setFats(resultSet.getDouble(4));
                vegetable.setCarbs(resultSet.getDouble(5));
                vegetable.setEnergy(resultSet.getDouble(6));
                vegetable.setFibre(resultSet.getDouble(7));
                vegetables.add(vegetable);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            this.close(preparedStatement);
            this.close(connection);
        }

        return vegetables;
    }
}
