package service;

import model.Library;

import java.util.List;

public interface LibraryService {

    String saveLibrary();

    void getAllLibraries();

    void getLibraryById(Long id);

    String updateLibrary(Long id);

    String deleteLibrary(Long id);
}
