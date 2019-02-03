package com.grzegorzmarkiewicz.document_manager.service;

public interface SecuritySerice {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
