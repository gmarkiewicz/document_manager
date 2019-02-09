package com.grzegorzmarkiewicz.document_manager.controller;

import com.grzegorzmarkiewicz.document_manager.model.Document;
import com.grzegorzmarkiewicz.document_manager.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class DocumentController {
    private static final Logger LOGGER = Logger.getLogger(DocumentController.class.getName());

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/documentManager", method = RequestMethod.GET)
    public String documentManager(Model model, Authentication authentication, Map<String, Object> map){
        model.addAttribute("userRole", authentication.getAuthorities());
        model.addAttribute("username", authentication.getName());

        try {
            map.put("documentList", documentRepository.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "documentManager";
    }
}
