package com.app.zadatak.service;

import com.app.zadatak.model.Client;
import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    
    Client getClientById(int id);
    
    Client createClient(Client client);
    
    Client updateClient(int id, Client client);
    
    void deleteClient(int id);
}