package com.app.zadatak.dto;

import lombok.Data;

@Data
public class ClientDto{

	private int id;
	private String name;
	private String country;
	private String city;
	private String street_name;
	private int street_number;
	private int zip;
}
