package com.example.demo.Invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties
@Entity
@Table(name = "header", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "docid" })
})
public class Invoice {
	
	@Id
	long docid;
	String documentNumber;
	BigDecimal netAmt;
	BigDecimal totAmt;
	String approver;
	
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	List<InvoiceLine> invoiceLines = new ArrayList<>();

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

	public Invoice() {
		System.out.println("Invoice::default constructor");
	}

	@Override
	public String toString() {
		return "Invoice [docid=" + docid + ", documentNumber=" + documentNumber + ", netAmt=" + netAmt + ", totAmt="
				+ totAmt + "]";
	}

	public List<InvoiceLine> getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}



	

}
