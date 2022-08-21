package com.app.zadatak.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.zadatak.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}