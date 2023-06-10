package com.itfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class JobDAO {
    // Creati un serviciu care se numeste "JobDAO" unde veti crea metode pentru manipularea tabelei "JOB".
    //     Metoda de select, metoda de insert, update pentru "DOMAIN"
    private final java.lang.String DB_URL = "jdbc:postgresql://localhost:5432/itfactory_users";
    private final java.lang.String DB_USER = "postgres";
    private final String DB_PASS = "***********";


    public void insertJobExample(Job job) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO JOB VALUES(?,?,?,?)");
            statement.setInt(1, job.getId());
            statement.setString(2, job.getName());
            statement.setString(3, job.getDomain());
            statement.setDouble(4, job.getBaseSalary());


            statement.execute();
            System.out.println("Insert executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }


    public void deleteJobExample(Job job) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM JOB WHERE ID=?");
            statement.setInt(1, job.getId());

            statement.execute();
            System.out.println("Delete executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void updateJobDomainExample(String domain, String newDomain) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE JOB SET domain=? WHERE domain=?");
            statement.setString(1, newDomain);
            statement.setString(2, domain);

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void updateJobDomainIndividualExample(int id, String newDomain) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE JOB SET domain=? WHERE id=?");
            statement.setString(1, newDomain);
            statement.setInt(2, id);

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void selectAllJobExample() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");
            Statement statement = connection.createStatement();
            System.out.println("Executing query: SELECT * FROM job");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM job");
            System.out.println("Lista de persoane\n--------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("domain"));
            }
            System.out.println("--------");

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}