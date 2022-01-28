package peaksoft;

import peaksoft.dao.Dao;
import peaksoft.dao.DaoImpl;
import peaksoft.service.ServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static ServiceImpl service=new ServiceImpl();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        while (true){
            commands();
            int numberOfCommand = sc.nextInt();
            switch (numberOfCommand) {
                case 1 -> {
                    service.createTablePerson();
                }
                case 2 -> {
                    service.savePerson("Aijamal", "Asangazieva", 19);
                    service.savePerson("Aza", "Bekov", 18);
                    service.savePerson("Uulkan", "Mamatsakova", 28);
                    service.savePerson("Aza", "Matkasymov", 17);
                    service.savePerson("Aza", "Muratov", 20);
                    service.savePerson("Aza", "Kanatov", 25);
                }
                case 3 -> {
                    service.getAllPerson().forEach(System.out::println);
                }
                case 4 -> {
                    service.getAllPersonByNameAndByAge().forEach(System.out::println);
                }
                case 5 -> {
                    service.updateAgeOfPerson();
                }
                case 6 -> {
                    service.removePersonByName();
                }
                default -> throw new Exception("Ввели неправильную команду");
            }
        }
    }

    public static void commands(){
        System.out.println("Press 1 to create table");
        System.out.println("Press 2 to save user");
        System.out.println("Press 3 to get all users");
        System.out.println("Press 4 to get user where name=Aza and age>20");
        System.out.println("Press 5 to update age of person");
        System.out.println("Press 6 to delete person where name is Aza");
    }

}