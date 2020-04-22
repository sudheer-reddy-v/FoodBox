package com.sudheer.securebank.model;

public class PaymentPOJO {
	private String name;
	private long cardno;
	private  int cvv;
	private double amt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCardno() {
		return cardno;
	}
	public void setCardno(long cardno) {
		this.cardno = cardno;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}

}
