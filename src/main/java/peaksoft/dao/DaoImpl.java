package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import peaksoft.model.Person;
import peaksoft.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class DaoImpl implements Dao {
    @Override
    public void createTablePerson() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("Add successfully");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void savePerson(String name, String surname, int age) {
        try {
            Person person = new Person(name, surname, age);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            session.close();
            System.out.println("Add successfully " + person);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> getAllPersonByNameAndByAge() {
        List<Person> list1 = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Person> list = session.createQuery("from Person").getResultList();
            session.getTransaction().commit();
            list1 = list.stream().filter((s) -> s.getName().equals("Aza")).filter((n) -> n.getAge() > 20).toList();

            session.close();
            return list1;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return list1;

    }

    @Override
    public void updateAgeOfPerson() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("update person SET age = 18 where name = 'Aza'").executeUpdate();
            System.out.println("update successfully");
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removePersonByName() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("delete from person where name='Aza'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("deleted successfully");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> getAllPerson() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Person> list = session.createQuery("from Person ").getResultList();
            session.getTransaction().commit();
            session.close();
            return list;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }return null;
    }
}