package com.example.demo.Validator;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.parallel.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Invoice.Invoice;
import com.example.demo.Invoice.InvoiceJPARepository;

@RestController
@RequestMapping("/v2")
public class ValidatorResource {

	@Autowired
	InvoiceJPARepository repository;

	@Autowired
	ValidatorService service;

	@GetMapping(path = "/health")
	public ResponseEntity test() {
		return ResponseEntity.status(HttpStatus.OK).body("UP");
	}

	@PostMapping(path = "/validate")
	public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice) {
		if (invoice == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't validate an empty invoice!");
		} else {
			List<Invoice> retInvoiceLst = repository.findByDocumentNumber(invoice.getDocumentNumber());
			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(invoice.getDocid()).toUri();*/
			
			return ResponseEntity.ok()
					.body(retInvoiceLst);
		}
	}

}
