package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.model.FileResponse;
import com.uni.UniversityWebService.model.Student;
import com.uni.UniversityWebService.services.DocumentService;
import com.uni.UniversityWebService.services.FileSystemStorageService;
import com.uni.UniversityWebService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/documents")
    public @ResponseBody ResponseEntity<?> getAllDocuments(){
        return new ResponseEntity(documentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/documents/me")
    public ResponseEntity<?> getLoggedUserDocuments(@AuthenticationPrincipal UserDetails userDetails){
        Student student = studentService.findByUserUsername(userDetails.getUsername());

        return new ResponseEntity(student.getDocuments(), HttpStatus.OK);
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
    public ResponseEntity<?> uploadFile(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("file") MultipartFile file) {
        String[] allowedContentTypes = {"image/jpeg", "image/png", "text/plain", "application/pdf"};

        if(file.getOriginalFilename().contains(",")){
            return new ResponseEntity("File names cannot contain a ',' character.", HttpStatus.BAD_REQUEST);
        }else{
            if (Arrays.asList(allowedContentTypes).contains(file.getContentType())) {
                String name = storageService.store(file, userDetails);
                FileResponse fileResponse = new FileResponse(name, file.getContentType(), file.getSize());
                return new ResponseEntity(fileResponse, HttpStatus.OK);
            } else {
                String message = file.getContentType() + " is not allowed, please try with a different file type.";
                return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
            }
        }
    }

}
