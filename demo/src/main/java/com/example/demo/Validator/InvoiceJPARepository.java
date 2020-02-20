package com.example.demo.Validator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "invoices", path = "invoices")
public interface InvoiceJPARepository extends JpaRepository<Invoice, Long>{

}
