package by.javaguru.profiler.storage;

import by.javaguru.profiler.api.exception.ImageStorageException;

import java.io.File;
import java.io.InputStream;

public interface ImageStorageService {

    void save(InputStream content, String imageName) throws ImageStorageException;

    void delete(String imageName) throws ImageStorageException;

    File getImage(String imageName);
}
