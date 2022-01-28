package peaksoft.service;

import peaksoft.model.Person;

import java.util.List;

public interface Service {
    void createTablePerson();
    void savePerson(String name,String surname,int age);
    List<Person> getAllPerson();
    List<Person> getAllPersonByNameAndByAge();
    void updateAgeOfPerson();
    void removePersonByName();
}
