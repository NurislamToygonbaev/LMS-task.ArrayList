package service.impl;

import db.DataBase;
import enums.Genre;
import model.Book;
import model.Library;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    @Override
    public String saveBook(Long libraryId) {
        Scanner scanner = new Scanner(System.in);
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                Book book = new Book();
                book.setId(GeneratorId.generatorBook());
                System.out.print("enter book name: ");
                book.setName(scanner.nextLine());
                System.out.print("enter book author: ");
                book.setAuthor(scanner.nextLine());
                System.out.print("enter book genre (P/D/F/N): ");
                String genre = scanner.nextLine();
                if (genre.equalsIgnoreCase("P")){
                    book.setGenre(Genre.POETRY);
                } else if (genre.equalsIgnoreCase("D")) {
                    book.setGenre(Genre.DRAMA);
                } else if (genre.equalsIgnoreCase("F")) {
                    book.setGenre(Genre.FICTION);
                } else if (genre.equalsIgnoreCase("N")) {
                    book.setGenre(Genre.NONFICTION);
                }
                library.books.add(book);
            }
        }
        return "Successfully book added";
    }

    @Override
    public void getAllBooks(Long libraryId) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                System.out.println(library.books);
            }
        }
    }

    @Override
    public void getBookById(Long libraryId, Long bookId) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                for (Book book : library.books) {
                    if (book.getId() == bookId){
                        System.out.println(book);
                    }
                }
            }
        }
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                library.books.removeIf(book -> book.getId() == bookId);
            }
        }
        return "Successfully book deleted";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : DataBase.libraries) {
            if (library.getId() == libraryId){
                library.books.clear();
            }
        }
    }
}
