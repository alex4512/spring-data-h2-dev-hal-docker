package com.example.demo.Validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Invoice.Invoice;
import com.example.demo.Invoice.InvoiceJPARepository;
import com.example.demo.approvalmatrix.ApprovalMatrix;

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

	@GetMapping(path = "/findByDocumentNumber")
	public ResponseEntity<?> findByDocNumber(@RequestBody Invoice invoice) {
		if (invoice == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't validate an empty invoice!");
		} else {
			List<Invoice> retInvoiceLst = repository.findByDocumentNumber(invoice.getDocumentNumber());
			/*
			 * URI location =
			 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			 * .buildAndExpand(invoice.getDocid()).toUri();
			 */

			return ResponseEntity.ok().body(retInvoiceLst);
		}
	}

	@GetMapping(path = "/validate")
	public ResponseEntity<?> validateInvoice(@RequestBody Invoice invoice) {
		if (invoice == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't validate an empty invoice!");
		} else {

			// String retMsgBody = service.validate(invoice);
			String url = "http://localhost:8091/Validator/matrix/findByCoder";
			/*
			 * restTemplate = new RestTemplate(); headers = new HttpHeaders();
			 * headers.setContentType(MediaType.APPLICATION_JSON);
			 * personJsonObject = new JSONObject(); personJsonObject.put("id",
			 * 1); personJsonObject.put("name", "John");
			 */

			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//List<ApprovalMatrix> list = (List<ApprovalMatrix>) restTemplate.getForObject(url, ApprovalMatrix.class);
			/**
			 *   ResponseEntity<Employee[]> entity = restTemplate.getForEntity(requestUri,
                                                                Employee[].class,
                                                                urlParameters);
  return entity.getBody() != null? Arrays.asList(entity.getBody()) :                          
                                   Collections.emptyList();

			 */
			ResponseEntity<ApprovalMatrix[]> entity = restTemplate.getForEntity(url + "?coder=" + invoice.getApprover(), ApprovalMatrix[].class);
			
			System.out.println(entity.toString());
//			return ntity.getBody() != null? Arrays.asList(entity.getBody()) :                          
//                Collections.emptyList();;
			if(entity.getBody() != null)
			{
				return ResponseEntity.ok().body(entity.getBody());
			}
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<?> notYetImplemented()
	{
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
			
}
