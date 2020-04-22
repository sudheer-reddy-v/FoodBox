package com.sudheer.foodbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="orderstatus")
public class OrderDetailsPOJO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int oid;
	private String placedby;
	private long phone;
	private String oname;
	private double amount;
	private String Status;
	
	public String getPlacedby() {
		return placedby;
	}
	public void setPlacedby(String placedby) {
		this.placedby = placedby;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

}
