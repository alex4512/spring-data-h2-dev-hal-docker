package com.example.demo.Validator;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
public class Invoice {

	@Id
	long docid;
	String documentNumber;
	BigDecimal netAmt;
	BigDecimal totAmt;
	
	
	public long getDocid() {
		return docid;
	}
	public void setDocid(long docid) {
		this.docid = docid;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public BigDecimal getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(BigDecimal netAmt) {
		this.netAmt = netAmt;
	}
	public BigDecimal getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}

	public Invoice(long docid, String documentNumber, BigDecimal netAmt, BigDecimal totAmt) {
		this.docid = docid;
		this.documentNumber = documentNumber;
		this.netAmt = netAmt;
		this.totAmt = totAmt;
	}
	
	public Invoice(){
		System.out.println("Invoice::default constructor");
	}
	
	@Override
	public String toString() {
		return "Invoice [docid=" + docid + ", documentNumber=" + documentNumber + ", netAmt=" + netAmt + ", totAmt="
				+ totAmt + "]";
	}

	
	
	
}
