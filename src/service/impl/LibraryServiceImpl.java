package service.impl;

import db.DataBase;
import model.Library;
import service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryService {
    @Override
    public String saveLibrary() {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.setId(GeneratorId.generator());
        System.out.print("enter name: ");
        library.setName(scanner.nextLine());
        System.out.print("enter address: ");
        library.setAddress(scanner.nextLine());
        DataBase.libraries.add(library);
        return "Successfully library created";
    }

    @Override
    public void getAllLibraries() {
        System.out.println(DataBase.libraries);
    }

    @Override
    public void getLibraryById(Long id) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == id){
                System.out.println(library);
            }
        }
    }

    @Override
    public String updateLibrary(Long id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("update name: ");
        String name = scanner.nextLine();
        for (Library library : DataBase.libraries) {
            if (library.getId() == id){
                library.setName(name);
            }
        }
        return "Successfully updated";
    }

    @Override
    public String deleteLibrary(Long id) {
        DataBase.libraries.removeIf(library -> library.getId() == id);
        return "Successfully deleted";
    }
}
