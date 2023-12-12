package service.impl;

import db.DataBase;
import enums.Gender;
import model.Book;
import model.Library;
import model.Reader;
import service.ReaderService;

import java.util.List;
import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String saveReader(long libraryId) {
        Scanner scanner = new Scanner(System.in);
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                Reader reader = new Reader();
                reader.setId(GeneratorId.generatorReader());
                System.out.print("enter full name: ");
                reader.setFullName(scanner.nextLine());
                System.out.print("enter email: ");
                reader.setEmail(scanner.nextLine());
                System.out.print("enter phone number: ");
                reader.setPhoneNumber(scanner.nextLine());
                System.out.print("enter gender (m/f): ");
                String gender = scanner.nextLine();
                while (true){
                    if (gender.equalsIgnoreCase("m")){
                        reader.setGender(Gender.MALE);
                        break;
                    } else if (gender.equalsIgnoreCase("f")) {
                        reader.setGender(Gender.FEMALE);
                        break;
                    } else System.out.println("incorrect!!!");
                }
                library.readers.add(reader);
            }
        }
        return "Successfully reader added";
    }

    @Override
    public void getAllReaders(long libraryId) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                System.out.println(library.readers);
            }
        }
    }

    @Override
    public void getReaderById(Long id) {
        for (Library library : DataBase.libraries) {
            for (Reader reader : library.readers) {
                if (reader.getId() == id){
                    System.out.println(reader);
                }
            }
        }
    }

    @Override
    public String updateReader(Long id) {
        System.out.print("enter new name: ");
        String name = new Scanner(System.in).nextLine();
        for (Library library : DataBase.libraries) {
            for (Reader reader : library.readers) {
                if (reader.getId() == id){
                    reader.setFullName(name);
                }
            }
        }
        return "Successfully reader updated";
    }

    @Override
    public String deleteReaderById(Long readerId) {
        for (Library library : DataBase.libraries) {
            library.readers.removeIf(reader -> reader.getId() == readerId);
        }
        return "Successfully reader deleted!!!";
    }
}
