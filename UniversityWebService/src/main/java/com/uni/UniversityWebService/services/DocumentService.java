package com.uni.UniversityWebService.services;

import com.uni.UniversityWebService.model.Document;
import com.uni.UniversityWebService.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(Document document){
        return documentRepository.save(document);
    }

    public void deleteDocument(Document document){
        documentRepository.delete(document);
    }

    public Document findById(Long id){
        return documentRepository.findById(id).get();
    }

    public List<Document> findAll(){
        return documentRepository.findAll();
    }
}
