import service.BookService;
import service.LibraryService;
import service.ReaderService;
import service.impl.BookServiceImpl;
import service.impl.LibraryServiceImpl;
import service.impl.ReaderServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForNumber = new Scanner(System.in);

        BookService bookService = new BookServiceImpl();
        LibraryService libraryService = new LibraryServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

        try {
            LOOP:
            while (true){
                menu();
                switch (scanForNumber.nextInt()){
                    case 0 -> {break LOOP;}
                    case 1 -> System.out.println(libraryService.saveLibrary());
                    case 2 -> libraryService.getAllLibraries();
                    case 3 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        libraryService.getLibraryById(id);
                    }
                    case 4 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.println(libraryService.updateLibrary(id));
                    }
                    case 5 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.println(libraryService.deleteLibrary(id));
                    }
                    case 6 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.println(bookService.saveBook(id));
                    }
                    case 7 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        bookService.getAllBooks(id);
                    }
                    case 8 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.print("enter book id: ");
                        long idBook = scanner.nextLong();
                        bookService.getBookById(id, idBook);
                    }
                    case 9 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.print("enter book id: ");
                        long idBook = scanner.nextLong();
                        bookService.deleteBook(id, idBook);
                    }
                    case 10 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        bookService.clearBooksByLibraryId(id);
                    }
                    case 11 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.println(readerService.saveReader(id));
                    }
                    case 12 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        readerService.getAllReaders(id);
                    }
                    case 13 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        readerService.getReaderById(id);
                    }
                    case 14 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        System.out.println(readerService.updateReader(id));
                    }
                    case 15 -> {
                        System.out.print("enter id: ");
                        long id = scanner.nextLong();
                        readerService.deleteReaderById(id);
                    }
                    default -> System.out.println("incorrect choice");
                }
            }
        } catch (Exception e){
            System.out.println("write correct Integer valid");
        }
    }

    private static void menu(){
        System.out.println("""
                0.  exit
                1.  save library
                2.  get all libraries
                3.  get library by id
                4.  update library
                5.  delete library
                6.  save book
                7.  get all books
                8.  get book by id
                9.  delete book
                10. clear books by library id
                11. save reader
                12. get all readers
                13. get reader by id
                14. update reader
                15. delete reader by id
                """);
    }
}