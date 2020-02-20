package com.example.demo.Invoice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
@Table(name = "body", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "lineNum" })
})
public class InvoiceLine {
	
	
	
	@Id
	@Column(name="lineNum")
	Integer lineNum;
	String orderNum;
	BigDecimal netAmt;
	BigDecimal totAmt;
	String description;
	String glAccount;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="docid")
	private Invoice invoice;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGlAccount() {
		return glAccount;
	}
	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	

	public InvoiceLine(Integer lineNum, String orderNum, BigDecimal netAmt, BigDecimal totAmt, String description,
			String glAccount, Invoice invoice) {
		this.lineNum = lineNum;
		this.orderNum = orderNum;
		this.netAmt = netAmt;
		this.totAmt = totAmt;
		this.description = description;
		this.glAccount = glAccount;
		this.invoice = invoice;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public Integer getLineNum() {
		return lineNum;
	}
	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public InvoiceLine() {
		System.out.println("InvoiceLine::default constructor");
		
	}
	
	
	
	
	
	
	
	
}
