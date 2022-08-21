package com.app.zadatak.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.zadatak.model.Client;
import com.app.zadatak.repository.ClientRepository;
import com.app.zadatak.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(int id) {
		Client client = clientRepository.findById(id).orElseThrow();
		return client;
	}

	@Override
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(int id, Client client) {
		Client clientToUpdate = clientRepository.findById(id).orElseThrow();
		
		clientToUpdate.setName(client.getName());
		clientToUpdate.setCountry(client.getCountry());
		clientToUpdate.setCity(client.getCity());
		clientToUpdate.setStreet_name(client.getStreet_name());
		clientToUpdate.setStreet_number(client.getStreet_number());
		clientToUpdate.setZip(client.getZip());
		
		return clientToUpdate;
	}

	@Override
	public void deleteClient(int id) {
		Client client = clientRepository.findById(id).orElseThrow();
		clientRepository.delete(client);
	}

}
