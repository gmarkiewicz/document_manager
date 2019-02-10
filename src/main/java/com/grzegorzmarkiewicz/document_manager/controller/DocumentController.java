package com.grzegorzmarkiewicz.document_manager.controller;

import com.grzegorzmarkiewicz.document_manager.model.Document;
import com.grzegorzmarkiewicz.document_manager.repository.DocumentRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class DocumentController {
    private static final Logger LOGGER = Logger.getLogger(DocumentController.class.getName());

    private SessionFactory sessionFactory = new Configuration().buildSessionFactory();
     

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/documentManager", method = RequestMethod.GET)
    public String documentManager(Map<String, Object> map){
        try {
            map.put("documentList", documentRepository.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "documentManager";
    }

    @RequestMapping(value = "/addFile",method = RequestMethod.POST)
    public String addDocument(@ModelAttribute("documentForm") Document documentForm,
                              @RequestParam("file") MultipartFile file){
        LOGGER.log(Level.INFO, "file name: " + file.getOriginalFilename() + " | file type: " + file.getContentType()
                + " | file size: " + file.getSize());
        try{
            Blob blob = Hibernate.getLobCreator(sessionFactory.openSession()).createBlob(file.getInputStream(),
                    file.getSize());
            documentForm.setPdfFile(blob);
            documentForm.setFileType(file.getContentType());
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            documentRepository.save(documentForm);
        }catch(Exception e){
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Added new file to db: " + documentForm.getName());
        return "redirect:/documentManager";
    }

    @RequestMapping(value = "/addFile", method = RequestMethod.GET)
    public String addFile(Model model){
        model.addAttribute("documentForm", new Document());
        return "addFile";
    }
}
