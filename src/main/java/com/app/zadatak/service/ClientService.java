package com.app.zadatak.service;

import java.util.List;

import com.app.zadatak.model.Client;

public interface ClientService {

    List<Client> getAllClients();
    
    Client getClientById(Integer id);
    
    Client createClient(Client client);
    
    Client updateClient(Integer id, Client client);
    
    void deleteClient(Integer id);
}