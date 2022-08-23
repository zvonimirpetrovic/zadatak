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
@Table(name = "projects")
public class Project{
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Clientid")
	private Integer client_id;
	
	@NonNull
	@Column(name = "Project_manager")
	private String project_manager;
	
	@Column(name = "Contact_email")
	private String contact_email;
	
	@Column(name = "Contact_number")
	private Integer contact_number;
	
	@NonNull
	@Column(name = "Billing_address")
	private Integer billing_address;
	
//	@Column(name = "Contact_number")
//	private Number contact_number;
//	
//	@NonNull
//	@Column(name = "Billing_address")
//	private Number billing_address;
}