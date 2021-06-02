package com.uni.UniversityWebService.services;

import com.uni.UniversityWebService.model.*;
import com.uni.UniversityWebService.repositories.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService {

    private final Path rootLocation;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage location", e);
        }
    }


    public String store(MultipartFile file, UserDetails userDetails) {
        DocumentType documentType = documentTypeRepository.findByCode("DP");
        String[] split = file.getOriginalFilename().split("\\.");
        split[0] = split[0] + "," + userDetails.getUsername();
        System.out.println("Original name " + file.getOriginalFilename());
        String filenameOnSystem = StringUtils.cleanPath(String.join(".", split));
        String filename = file.getOriginalFilename();

        Document newDocument = new Document(file.getOriginalFilename(), filenameOnSystem, documentType);

        Student student = studentService.findByUserUsername(userDetails.getUsername());
        student.getDocuments().add(newDocument);
        studentService.saveStudent(student);
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filenameOnSystem),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }

        return filename;
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) throws FileNotFoundException {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new FileNotFoundException("Could not read file: " + filename);
            }
        }
        catch (FileNotFoundException | MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filename);
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
