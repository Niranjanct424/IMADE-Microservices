package com.javatechie.spring.procedure.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.procedure.api.model.Ticket;

public interface TicketRepo extends JpaRepository<Integer, Ticket>{
	
}
