package com.example.demo.approvalmatrix;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="approvalmatrix")
public class ApprovalMatrix {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String coder;
	String glCode;
	BigDecimal amount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return coder;
	}
	public void setUsername(String username) {
		this.coder = username;
	}
	public String getGlCode() {
		return glCode;
	}
	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ApprovalMatrix() {
	}
	@Override
	public String toString() {
		return "ApprovalMatrix [id=" + id + ", username=" + coder + ", glCode=" + glCode + ", amount=" + amount
				+ "]";
	}
	
	
	
	
}
