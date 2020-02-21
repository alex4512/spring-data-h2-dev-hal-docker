package com.example.demo.approvalmatrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matrix")
public class ApprovalMatrixRestController {

	@Autowired
	ApprovalMatrixJPARepo repository;
	
	@GetMapping("/findByCoder")
	ResponseEntity<?> findByCoder(@RequestParam String coder)
	{
		if(coder==null)
			return ResponseEntity.badRequest().body("Coder cannot be null");
		return ResponseEntity.ok().body(repository.findByCoder(coder));
	}
	
}
