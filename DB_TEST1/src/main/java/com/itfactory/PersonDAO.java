package com.itfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PersonDAO {

    //Creati un serviciu care se numeste "PersonDAO" unde veti muta metodele din clasa main (nu vor fi statice) si se
    // vor crea diverse metode pentru manipularea persoanelor. (inclusiv cele de sus)

    private final java.lang.String DB_URL = "jdbc:postgresql://localhost:5432/itfactory_users";
    private final java.lang.String DB_USER = "postgres";
    private final String DB_PASS = "***********";


    public void deletePersonExample(Person person) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
            statement.setInt(1, person.getId());

            statement.execute();
            System.out.println("Delete executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void updatePersonExample(String name, String newName) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE PERSON SET name=? WHERE name=?");
            statement.setString(1, newName);
            statement.setString(2, name);

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void updatePersonEmail(int id, String email) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE PERSON SET EMAIL=? WHERE ID=?");
            statement.setString(1, email);
            statement.setInt(2, id);

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }


    public void updatePersonTelephone(int id, String newTelefon) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE PERSON SET telefon=? WHERE id=?");
            statement.setString(1, newTelefon);
            statement.setInt(2, id);

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void insertPersonExample(Person person) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getJobId());
            statement.setString(5, person.getTelefon());

            statement.execute();
            System.out.println("Insert executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void insertPersonTelefon(Person person) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO PERSON (id, name, email, jobId, telefon) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getJobId());
            statement.setString(5, person.getTelefon());


            statement.execute();
            System.out.println("Insert executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }


    public void selectAllPersonsExample() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");
            Statement statement = connection.createStatement();
            System.out.println("Executing query: SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
            System.out.println("Lista de persoane\n--------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
                System.out.println(resultSet.getString("telefon"));
            }
            System.out.println("--------");

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}