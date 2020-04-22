package com.sudheer.foodbox.service;

import com.sudheer.foodbox.entity.OrderPOJO;
import com.sudheer.foodbox.entity.OrderStatusPOJO;

public interface OrderService {
	public OrderStatusPOJO processOrderService(OrderPOJO dao);
	

}
