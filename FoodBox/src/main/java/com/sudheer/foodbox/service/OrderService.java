package com.sudheer.foodbox.service;

import com.sudheer.foodbox.entity.OrderPOJO;
import com.sudheer.foodbox.model.StatusModel;

public interface OrderService {
	public StatusModel processOrderService(OrderPOJO dao);
	

}
