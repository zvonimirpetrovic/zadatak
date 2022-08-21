package com.app.zadatak.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.zadatak.dto.ClientDto;
import com.app.zadatak.model.Client;
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
	@CrossOrigin
	@GetMapping
	public List<ClientDto> getAllClients(){  
		return clientService.getAllClients()
				.stream()
				.map(client -> modelMapper.map(client, ClientDto.class))
				.collect(Collectors.toList()); 
	}  
	
	// Get 1 client
	@CrossOrigin
	@GetMapping("/{id}")  
	public  ResponseEntity<ClientDto> getClient(@PathVariable("id") int id){  
		Client client = clientService.getClientById(id);  
		
		ClientDto clientDto = modelMapper.map(client, ClientDto.class);
		return ResponseEntity.ok().body(clientDto);
	}  
	
	// Create client
	@CrossOrigin
	@PostMapping
	public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {

		// convert DTO to entity
		Client clientReq = modelMapper.map(clientDto, Client.class);

		Client client = clientService.createClient(clientReq);

		// convert entity to DTO
		ClientDto clientRes = modelMapper.map(client, ClientDto.class);

		return new ResponseEntity<ClientDto>(clientRes, HttpStatus.CREATED);
	}
	
	// Update client
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<ClientDto> updatePost(@PathVariable int id, @RequestBody ClientDto clientDto) {

		// convert DTO to Entity
		Client clientReq = modelMapper.map(clientDto, Client.class);

		Client client = clientService.updateClient(id, clientReq);

		// entity to DTO
		ClientDto clientRes = modelMapper.map(client, ClientDto.class);

		return ResponseEntity.ok().body(clientRes);
	}
	
	// Delete a client
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") int id) {
		clientService.deleteClient(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}  