package service;

import model.Book;

import java.util.List;

public interface BookService {

    String saveBook(Long libraryId);

    void getAllBooks(Long libraryId);

    void getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId,Long bookId);

    void clearBooksByLibraryId(Long libraryId);
}
