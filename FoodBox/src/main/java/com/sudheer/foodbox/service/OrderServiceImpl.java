package com.sudheer.foodbox.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.foodbox.entity.MenuDetailsPOJO;
import com.sudheer.foodbox.entity.OrderPOJO;
import com.sudheer.foodbox.model.StatusModel;
import com.sudheer.foodbox.repo.MenuRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private MenuRepository menu;
	@Autowired
	private OrderInfoSerImpl oinfo;

	@Override
	public StatusModel processOrderService(OrderPOJO dao) {
		StatusModel resdao= new StatusModel();
	boolean b=	menu.existsById(dao.getItemid());
	if(b)
	{
		long phone= dao.getPhone();
		
		String l=menu.findPrice(dao.getItemid());
	Optional<MenuDetailsPOJO> opt=menu.findById(dao.getItemid());
	MenuDetailsPOJO dao2=opt.get();
	oinfo.saveOrderInfo(dao2,phone);
	
		resdao.setErrorcode(200);
		resdao.setErrorMsg("Make a payment of "+l+" to place the order ");
		
		return resdao;
	}
	else
	{
		resdao.setErrorcode(603);
		resdao.setErrorMsg("Item is out of stock,please try again later");
		return resdao;
	}
	
	

}
}
