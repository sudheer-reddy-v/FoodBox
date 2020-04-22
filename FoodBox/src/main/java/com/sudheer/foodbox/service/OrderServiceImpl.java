package com.sudheer.foodbox.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.foodbox.entity.MenuDetailsPOJO;
import com.sudheer.foodbox.entity.OrderPOJO;
import com.sudheer.foodbox.entity.OrderStatusPOJO;
import com.sudheer.foodbox.repo.MenuRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private MenuRepository menu;
	@Autowired
	private OrderInfoSerImpl oinfo;

	@Override
	public OrderStatusPOJO processOrderService(OrderPOJO dao) {
		OrderStatusPOJO resdao= new OrderStatusPOJO();
	boolean b=	menu.existsById(dao.getItemid());
	if(b)
	{
		long phone= dao.getPhone();
		
		String l=menu.findPrice(dao.getItemid());
	Optional<MenuDetailsPOJO> opt=menu.findById(dao.getItemid());
	MenuDetailsPOJO dao2=opt.get();
	oinfo.saveOrderInfo(dao2,phone);
	
		resdao.setScode(200);
		resdao.setSmsg("pay"+l+" to place the order ");
		
		return resdao;
	}
	else
	{
		resdao.setScode(603);
		resdao.setSmsg("item not found please try again");
		return resdao;
	}
	
	

}
}
