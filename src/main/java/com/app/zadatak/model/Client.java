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
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	@Column(name = "Name")
	private String name;
	
	@NonNull
	@Column(name = "Country")
	private String country;
	
	@NonNull
	@Column(name = "City")
	private String city;
	
	@NonNull
	@Column(name = "Street_name")
	private String street_name;
	
	@NonNull
	@Column(name = "Street_number")
	private Integer street_number;
	
	@NonNull
	@Column(name = "Zip")
	private Integer zip;
	
//	@NonNull
//	@Column(name = "Street_number")
//	private Number street_number;
//	
//	@NonNull
//	@Column(name = "Zip")
//	private Number zip;
}