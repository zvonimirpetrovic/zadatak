package com.app.zadatak.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zadatak.dto.ClientDto;
import com.app.zadatak.service.ClientService;  

@RestController  
@RequestMapping("/api/clients")
public class ClientController {
		
	@Autowired
	private ModelMapper modelMapper;

	private ClientService clientService; 

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	} 
	
	// Get all clients
	@GetMapping
	public List<ClientDto> getAllClients(){  
		return clientService.getAllClients()
				.stream()
				.map(client -> modelMapper.map(client, ClientDto.class))
				.collect(Collectors.toList()); 
	}  
	
//	// Get 1 client
//	@GetMapping("/api/clients/{id}")  
//	private ClientDto getClient(@PathVariable("id") int clientId){  
//		return clientService.getClientById(clientId);  
//	}  
	
	// Delete a client
//	@DeleteMapping("/api/clients/{id}")  
//	private ResponseEntity<String> deleteClient(@PathVariable("id") int clientid){  
////		return clientService.deleteClient(clientid);  
//	}  
	////creating post mapping that post the book detail in the database  
	//@PostMapping("/books")  
	//private int saveBook(@RequestBody Books books)   
	//{  
	//booksService.saveOrUpdate(books);  
	//return books.getBookid();  
	//}  
	////creating put mapping that updates the book detail   
	//@PutMapping("/books")  
	//private Books update(@RequestBody Books books)   
	//{  
	//booksService.saveOrUpdate(books);  
	//return books;  
	//}  
	
//    @PostMapping
//    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
//        Client savedClient = clientRepository.save(client);
//        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
//        Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
//        currentClient.setName(client.getName());
//        currentClient.setEmail(client.getEmail());
//        currentClient = clientRepository.save(client);
//
//        return ResponseEntity.ok(currentClient);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteClient(@PathVariable Long id) {
//        clientRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
}  