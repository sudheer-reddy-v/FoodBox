package com.sudheer.foodbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.foodbox.configuration.FoodBoxFeign;
import com.sudheer.foodbox.model.PaymentModel;
import com.sudheer.foodbox.model.PaymentStatusModel;


@RestController
public class FoodPaymentController {
	@Autowired
	private  FoodBoxFeign fFign;
	@RequestMapping(value = "/pay",method =RequestMethod.POST,consumes = "application/json")
	PaymentStatusModel doPayment(@RequestBody  PaymentModel model)
	{
		PaymentStatusModel resdto= fFign.doPayment(model);
		if(resdto.getPcode()==200)
		{
			
		}
		return resdto;

}
}
