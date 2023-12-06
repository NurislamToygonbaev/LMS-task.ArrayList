package service;

import model.Reader;

import java.util.List;

public interface ReaderService {

    String saveReader(long libraryId);

    void getAllReaders(long libraryId);

    void getReaderById(Long id);

    String updateReader(Long id);

    String deleteReaderById(Long readerId);
}
