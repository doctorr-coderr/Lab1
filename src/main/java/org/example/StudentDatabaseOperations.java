package org.example;

import java.sql.*;

public class StudentDatabaseOperations {
    public static void main(String[] args) {
        String baseUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "my77avTWr@#";

        try {
            Connection serverConnection = DriverManager.getConnection(baseUrl, username, password);
            Statement serverStatement = serverConnection.createStatement();

            serverStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS StudentsDB");
            System.out.println("Database 'StudentsDB' is ready.");

            serverStatement.close();
            serverConnection.close();

            String dbUrl = "jdbc:mysql://localhost:3306/StudentsDB";
            Connection dbConnection = DriverManager.getConnection(dbUrl, username, password);
            Statement dbStatement = dbConnection.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, firstname VARCHAR(255), lastname VARCHAR(255), grade INT)";
            dbStatement.execute(createTableSQL);
            System.out.println("Table 'students' created successfully.");

            dbStatement.close();
            dbConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}