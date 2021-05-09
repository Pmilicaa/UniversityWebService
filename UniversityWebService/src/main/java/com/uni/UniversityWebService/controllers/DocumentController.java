package com.uni.UniversityWebService.controllers;

import com.uni.UniversityWebService.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping(path = "/documents")
    public @ResponseBody ResponseEntity<?> getAllDocuments(){
        return new ResponseEntity(documentService.findAll(), HttpStatus.OK);
    }

}
