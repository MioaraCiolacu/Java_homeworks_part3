package com.itfactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final java.lang.String DB_URL = "jdbc:postgresql://localhost:5432/itfactory_users";
    private static final java.lang.String DB_USER = "postgres";
    private static final String DB_PASS = "***********";

    public static void main(String[] args) {
        System.out.println(selectAllPersonsExample());
        System.out.println("++++++++++++++++++++++");

        Person person = new Person(4444, "Vasile Curca", "vasilecurca@itfactory.ro", 1241);
        deletePersonExample(person);


        System.out.println("++++++++++++++++++++++");

        Person persoana = new Person(9999, "Ioana Carla", "ioanacarla@itfactory.ro", 1233);
        deletePersonExample(persoana);
        System.out.println(insertPersonExample(persoana));
        System.out.println("++++++++++++++++++++++");

        Person persoana1 = new Person(2222, "Ana Maria", "anamaria@itfactory.ro", 1233);
        deletePersonExample(persoana1);
        System.out.println(insertPersonExample(persoana1));
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");


        updatePersonEmail(2222,"mariaana@itfactory.ro");
        System.out.println(selectAllPersonsExample());

        updatePersonExample();
        System.out.println(selectAllPersonsExample());

    }

    private static Person deletePersonExample(Person person) {


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
        return person;
    }

    public static void updatePersonExample() {
        //3. Pe baza metodei "updatePersonExample" sa se creese o metoda care sa primeasca ca parametru id-ul persoanei
        // pentru care se face update la email si noua valoare a emailului. Metoda se va numi "updatePersonEmail".
        Person person = new Person(2222, "Ana Maria", "anamaria@itfactory.ro", 1241);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE PERSON SET JOBID=? WHERE ID=?");
            statement.setInt(1, 1233);
            statement.setInt(2, person.getId());

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public static void updatePersonEmail(int id, String newEmail) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("UPDATE PERSON SET EMAIL=? WHERE ID=?");
            statement.setString(1, newEmail);
            statement.setInt(2, id);

            statement.execute();
            System.out.println("Update executed successfully");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }



    public static boolean insertPersonExample(Person persoana) {
        //2. Ajustati metoda "insertPersonExample" sa primeasca ca parametru un obiect de tipul persoana si sa o insereze
        // in baza de date.

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?)");
            statement.setInt(1, persoana.getId());
            statement.setString(2, persoana.getName());
            statement.setString(3, persoana.getEmail());
            statement.setInt(4, persoana.getJobId());

            boolean success = statement.execute();
            System.out.println("Insert executed successfully");

            return success;

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
            return false;  // va afisa si "false": Dacă metoda execute() returneaza false, acest lucru indica faptul ca
            // interogarea nu a returnat un rezultat de tip ResultSet, ceea ce este de asteptat pentru o interogare INSERT.
            //In cazul unei interogari INSERT, metoda execute() returneaza false pentru a indica ca interogarea a fost
            // executata cu succes, dar nu a generat un rezultat de tip ResultSet. Astfel, valoarea returnata de metoda
            // execute() nu indica daca înregistrarea a fost inserata sau nu in baza de date, decatprin mesajul System.out.println("Insert executed successfully");
        }
    }


    public static List<Person> selectAllPersonsExample() {
        //1. Ajustati metoda "selectAllPersonsExample" sa selecteze toate persoanele si sa returneze o lista.  (List<Person>)
        List<Person> persons = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to PostgreSQL database!");
            System.out.println("Prepare statement");

            Statement statement = connection.createStatement();
            System.out.println("Executing query: SELECT * FROM person");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            System.out.println("Lista de persoane\n--------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int jobId = resultSet.getInt("jobid");

                Person person = new Person(id, name, email, jobId);
                persons.add(person);

            }
            for (Person person : persons) {
                System.out.println(person);
            }

            System.out.println("--------");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

        return persons;
    }
}


//INITIAL:

//  public static void selectAllPersonsExample()
//    {
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS))
//        {
//
//            System.out.println("Connected to PostgreSQL database!");
//            System.out.println("Prepare statement");
//            Statement statement = connection.createStatement();
//            System.out.println("Executing query: SELECT * FROM person");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
//            System.out.println("Lista de persoane\n--------");
//            while (resultSet.next())
//            {
//                System.out.println(resultSet.getString("name"));
//            }
//            System.out.println("--------");
//
//        }
//        catch (SQLException e)
//        {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }


// public static void insertPersonExample() {
//        //2. Ajustati metoda "insertPersonExample" sa primeasca ca parametru un obiect de tipul persoana si sa o insereze
//           // in baza de date.
//        Person person = new Person(41231, "Vasile Curca", "vasilecurca@itfactory.ro", 1241);
//        Person person1 = new Person(1234, "Mara-Sofia", "marasofia@itfactory.ro", 3191);
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
//            System.out.println("Connected to PostgreSQL database!");
//            System.out.println("Prepare statement");
//
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?)");
//            statement.setInt(1, person.getId());
//            statement.setString(2, person.getName());
//            statement.setString(3, person.getEmail());
//            statement.setInt(4, person.getJobId());
//
//            statement.execute();
//
//            PreparedStatement statement1 = connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?)");
//            statement1.setInt(1, person1.getId());
//            statement1.setString(2, person1.getName());
//            statement1.setString(3, person1.getEmail());
//            statement1.setInt(4, person1.getJobId());
//
//            statement1.execute();
//            System.out.println("Insert executed successfully");
//        } catch (SQLException e) {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }
//    }




//private static void deletePersonExample()
//    {
//        Person person = new Person(4123, "Vasile Curca", "vasilecurca@itfactory.ro", 1241);
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS))
//        {
//            System.out.println("Connected to PostgreSQL database!");
//            System.out.println("Prepare statement");
//
//            PreparedStatement statement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
//            statement.setInt(1, person.getId());
//
//            statement.execute();
//            System.out.println("Delete executed successfully");
//        }
//        catch (SQLException e)
//        {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }
//    }