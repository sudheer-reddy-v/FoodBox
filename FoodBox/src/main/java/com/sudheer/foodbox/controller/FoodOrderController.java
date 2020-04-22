package com.sudheer.foodbox.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.foodbox.entity.OrderPOJO;
import com.sudheer.foodbox.entity.OrderStatusPOJO;
import com.sudheer.foodbox.model.OrderDetailsModel;
import com.sudheer.foodbox.model.OrderStatusModel;
import com.sudheer.foodbox.service.OrderServiceImpl;
@RestController
public class FoodOrderController {
	@Autowired
	private  OrderServiceImpl oser;
	@RequestMapping(value ="/process", method = RequestMethod.POST,consumes = "application/json")
	public OrderStatusModel placeOrder(@RequestBody OrderDetailsModel dto)
	{
		OrderPOJO dao= new OrderPOJO();
		BeanUtils.copyProperties(dto, dao);
		OrderStatusPOJO resdao=oser.processOrderService(dao);
		OrderStatusModel resdto= new OrderStatusModel();
		BeanUtils.copyProperties(resdao, resdto);
		return resdto;
		
		
	}
	

}
