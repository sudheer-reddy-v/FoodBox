package com.sudheer.foodbox.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudheer.foodbox.model.PaymentModel;
import com.sudheer.foodbox.model.PaymentStatusModel;

@FeignClient(name="")
public interface FoodBoxFeign {
	@RequestMapping(value = "/payment",method =RequestMethod.POST,consumes = "application/json")
	PaymentStatusModel doPayment(@RequestBody  PaymentModel dto);

}
