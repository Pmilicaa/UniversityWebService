package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.FileResponse;
import com.uni.UniversityWebService.services.DocumentService;
import com.uni.UniversityWebService.services.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping(path = "/documents")
    public @ResponseBody ResponseEntity<?> getAllDocuments(){
        return new ResponseEntity(documentService.findAll(), HttpStatus.OK);
    }

    @Autowired
    private FileSystemStorageService storageService;

    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        try{
            Resource resource = storageService.loadAsResource(filename);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("File not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/documents/upload")
    @ResponseBody
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String name = storageService.store(file);

        return new FileResponse(name, file.getContentType(), file.getSize());
    }

}
