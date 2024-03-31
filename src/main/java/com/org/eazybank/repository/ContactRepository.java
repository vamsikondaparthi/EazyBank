package com.org.eazybank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.eazybank.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}