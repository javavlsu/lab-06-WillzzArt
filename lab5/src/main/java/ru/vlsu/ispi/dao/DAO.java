package ru.vlsu.ispi.dao;

import ru.vlsu.ispi.beans.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO{
    private final Configs configs;

    public DAO(Configs configs) {
        this.configs = configs;
    }

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + configs.dbHost + ":"
                + configs.dbPort + "/" + configs.dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                configs.dbUser, configs.dbPass);

        return dbConnection;
    }
}
