package peaksoft.service;

import peaksoft.dao.Dao;
import peaksoft.dao.DaoImpl;
import peaksoft.model.Person;

import java.util.List;

public class ServiceImpl implements Service{

        Dao dao=new DaoImpl();

    @Override
    public void createTablePerson() {
        dao.createTablePerson();

    }

    @Override
    public void savePerson(String name, String surname, int age) {
        dao.savePerson(name,surname,age);

    }

    @Override
    public List<Person> getAllPerson() {
        return dao.getAllPerson();
    }

    @Override
    public List<Person> getAllPersonByNameAndByAge() {
        return dao.getAllPersonByNameAndByAge();
    }

    @Override
    public void updateAgeOfPerson() {
        dao.updateAgeOfPerson();

    }

    @Override
    public void removePersonByName() {
        dao.removePersonByName();

    }
}
