package com.epam.jwd.service;

import com.epam.jwd.dao.DaoException;
import com.epam.jwd.domain.SaladDressing;
import com.epam.jwd.domain.SaladDressingType;
import com.epam.jwd.domain.Vegetable;
import com.epam.jwd.domain.VegetableType;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public interface Dao {
    static MysqlDataSource createMysqlDataSource() {
        MysqlDataSource dataSource = null;
        Properties prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("database.properties");
            prop.load(inputStream);
            dataSource = new MysqlDataSource();
            dataSource.setURL(prop.getProperty("url"));
            dataSource.setUser(prop.getProperty("user"));
            dataSource.setPassword(prop.getProperty("password"));
            dataSource.setCharacterEncoding(prop.getProperty("characterEncoding"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dataSource;
    }
    static List<SaladDressing> getVegetableFromDatabaseToList(ResultSet resultSet) throws DaoException {
        List<SaladDressing> saladDressings = new ArrayList();
        try {
            while (resultSet.next()) {
                SaladDressing saladDressing = new SaladDressing();
                saladDressing.setId(resultSet.getInt(1));
                saladDressing.setName(resultSet.getString(2));
                saladDressing.setSaladDressingTypes(SaladDressingType.valueOf(resultSet.getString(3).toUpperCase(Locale.ROOT)));
                saladDressing.setProteins(resultSet.getDouble(4));
                saladDressing.setFats(resultSet.getDouble(5));
                saladDressing.setCarbs(resultSet.getDouble(6));
                saladDressing.setEnergy(resultSet.getDouble(7));
                saladDressings.add(saladDressing);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return saladDressings;
    }
    static List<Vegetable> getSaladDressingFromDatabaseToList(ResultSet resultSet) throws DaoException {
        List<Vegetable> vegetables = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Vegetable vegetable = new Vegetable();
                vegetable.setId(resultSet.getInt(8));
                vegetable.setName(resultSet.getString(1));
                vegetable.setVegetableType(VegetableType.valueOf(resultSet.getString(2).toUpperCase(Locale.ROOT)));
                vegetable.setProteins(resultSet.getDouble(3));
                vegetable.setFats(resultSet.getDouble(4));
                vegetable.setCarbs(resultSet.getDouble(5));
                vegetable.setEnergy(resultSet.getDouble(6));
                vegetable.setFibre(resultSet.getDouble(7));
                vegetables.add(vegetable);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return vegetables;
    }

}
