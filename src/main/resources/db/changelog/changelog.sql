-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE Clients (
	Id SERIAL PRIMARY KEY, 
	Name VARCHAR(50) NOT NULL, 
	Country VARCHAR(50) NOT NULL, 
	City VARCHAR(50) NOT NULL, 
	Street_name VARCHAR(50) NOT NULL, 
	Street_number INT NOT NULL, 
	Zip INT NOT NULL
	)

-- changeset liquibase:2
CREATE TABLE Projects (
	Id SERIAL PRIMARY KEY,
	Name VARCHAR(50) NOT NULL, 
	ClientId INT NOT NULL, 
	Project_manager VARCHAR(50) NOT NULL, 
	Contact_email VARCHAR(50), 
	Contact_number INT, 
	Billing_address INT NOT NULL,
	CONSTRAINT fk_Client
      FOREIGN KEY(ClientId) 
	  REFERENCES Clients(id)
	)
	
-- changeset liquibase:3
INSERT INTO public.clients
(name, country, city, street_name, street_number, zip)
SELECT  
    'Client ' || n as name, 
    'Country ' || n as country,
    'City ' || n as street_name,
    'Street ' || n as street_name,
    n as street_number,
    n*1000 as zip
 FROM generate_series(1, 100) as n
 
 -- changeset liquibase:4
INSERT INTO public.projects
(name, clientid, project_manager, contact_email, contact_number, billing_address)
SELECT  
    'Project ' || n as name, 
    floor(random() * 99 + 1)::int as Clientid,
    'Project manager ' || n as project_manager,
    'Contact email ' || n as contact_email,
    n * floor(random() * 100000 + 1)::int as contact_number,
    n as billing_address
 FROM generate_series(1, 100) as n