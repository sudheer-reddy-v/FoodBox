package com.sudheer.foodbox.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="MENU_DETAILS")
public class MenuDetailsPOJO {
	
	@Id
	public int menuId;
	public String vendorId;
	public String menuName;
	public String menuDesc;
	public double price;
	public String menuCategory;
	
	public MenuDetailsPOJO() {
		
	}
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	
	
	
	

}
