package com.app.zadatak.dto;

import lombok.Data;

@Data
public class ProjectDto{
	
	private Integer id;
	private String name;
	private Integer client_id;
	private String project_manager;
	private String contact_email;
	private Integer contact_number;
	private Integer billing_address;
	
//	private Number contact_number;
//	private Number billing_address;
//	private String client_name;
}
