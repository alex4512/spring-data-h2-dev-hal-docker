package com.example.demo.Invoice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "invoices", path = "invoices")
public interface InvoiceJPARepository extends JpaRepository<Invoice, Long>{

	
	List<Invoice> findByDocumentNumber(String documentNumber);

}
