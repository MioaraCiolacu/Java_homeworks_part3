package com.itfactory;

public class ClasaMainPentruOptionala_PersonDAO {

    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person(9876, "Veta Biris", "vetabiris@itfactory.ro", 1241);
        personDAO.deletePersonExample(person);
        System.out.println("________________");

        personDAO.insertPersonExample(person);
        System.out.println(person);
        System.out.println("________________");

        personDAO.updatePersonEmail(9876, "biris@itfactory.ro");
        System.out.println("________________");

        Person person1 = new Person(4123, "Vasile Curca", "vasilecurca@itfactory.ro", 1241);
        personDAO.deletePersonExample(person1);
        personDAO.insertPersonExample(person1);
        personDAO.deletePersonExample(person1);
        personDAO.insertPersonTelefon(person1);
        personDAO.updatePersonExample("Vasile Curca", "Vasile N. Curca");
        System.out.println("________________");


        personDAO.updatePersonTelephone(9876, "1234567890");
        personDAO.updatePersonTelephone(9999, "9876543210");


        personDAO.selectAllPersonsExample();


    }
}
