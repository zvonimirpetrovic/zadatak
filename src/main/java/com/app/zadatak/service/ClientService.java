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
//
//
//package com.app.zadatak.service;
//
//import com.app.zadatak.dto.ClientDto;
//import com.app.zadatak.model.Client;
//import com.app.zadatak.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ClientService {
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    public List<ClientDto> getAllClients(){
//    	
//    	// identično browseList
//    	//JPAQuery<?> query = new getEm();
//    	// queryDSL 4.4.0
//    	
//    	// query.from(tablica).join(novaTablica).where(uvjet);
//    // returnaš  .fetch()
//    	
//    	
//        return clientRepository.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//
//    }
//    
//    public ClientDto getClientById(int id){  
//    	return convertEntityToDto(clientRepository.findById(id).get());  
//    }  
//    
//    public ResponseEntity<String> deleteClient(int id) {
//    	return new ResponseEntity<>("Record deleted", HttpStatus.OK);
//    }
//
//
//}
//
