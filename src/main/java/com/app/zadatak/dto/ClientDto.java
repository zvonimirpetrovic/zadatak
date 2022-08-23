package com.app.zadatak.dto;

import lombok.Data;

@Data
public class ClientDto{

	private int id;
	private String name;
	private String country;
	private String city;
	private String street_name;
	private Integer street_number;
	private Integer zip;
//	private Number street_number;
//	private Number zip;
}
