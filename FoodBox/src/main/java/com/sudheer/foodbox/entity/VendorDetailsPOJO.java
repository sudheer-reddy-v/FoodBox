package com.sudheer.foodbox.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class VendorDetailsPOJO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int vid;
	private String vname;
	@OneToMany(targetEntity = MenuDetailsPOJO.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "venid",referencedColumnName = "vid")
	private Set menu;
	public Set getMenu() {
		return menu;
	}
	public void setMenu(Set menu) {
		this.menu = menu;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}

}
