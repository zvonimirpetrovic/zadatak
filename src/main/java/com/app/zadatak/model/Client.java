package com.app.zadatak.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Street_name")
	private String street_name;
	
	@Column(name = "Street_number")
	private int street_number;
	
	@Column(name = "Zip")
	private int zip;
}