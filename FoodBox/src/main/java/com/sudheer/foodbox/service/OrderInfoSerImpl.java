package com.sudheer.foodbox.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sudheer.foodbox.entity.MenuDetailsPOJO;
import com.sudheer.foodbox.entity.OrderDetailsPOJO;
import com.sudheer.foodbox.repo.OrderInfoRepo;
import com.sudheer.foodbox.repo.Regrepo;

public class OrderInfoSerImpl implements OrderInfo {
	@Autowired
private OrderInfoRepo orepo;
	@Autowired
	private Regrepo regrepo;
	@Override
	public void saveOrderInfo(MenuDetailsPOJO dao,long phone) {
		OrderDetailsPOJO odao= new OrderDetailsPOJO();
		String pleacedby=regrepo.findUsername(phone);
		odao.setPhone(phone);
		odao.setPlacedby(pleacedby);
		odao.setAmount(dao.getPrice());
		odao.setOname(dao.getMenuName());
		odao.setStatus("pending");
		orepo.save(odao);
	}

}
