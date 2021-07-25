package com.epam.jwd.dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDataSourceFactory {

    public static MysqlDataSource createMysqlDataSource () {
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
}
