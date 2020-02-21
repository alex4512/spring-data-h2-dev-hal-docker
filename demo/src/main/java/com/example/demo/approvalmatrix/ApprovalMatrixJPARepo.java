package com.example.demo.approvalmatrix;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "matrix", path = "matrix")
public interface ApprovalMatrixJPARepo extends JpaRepository<ApprovalMatrix, Long>{

	@RestResource(exported = true)
	public List<ApprovalMatrix> findByCoder(String coder);
}
