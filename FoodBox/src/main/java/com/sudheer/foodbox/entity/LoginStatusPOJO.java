package com.sudheer.foodbox.entity;

import java.util.List;

public class LoginStatusPOJO {
	private int errorcode;
	private String errormsg;
	private List vendors;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public List getVendors() {
		return vendors;
	}
	public void setVendors(List vendors) {
		this.vendors = vendors;
	}

}
