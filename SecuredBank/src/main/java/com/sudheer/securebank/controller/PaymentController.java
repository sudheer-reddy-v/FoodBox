package com.sudheer.securebank.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.securebank.entity.PaymentEntity;
import com.sudheer.securebank.model.PaymentPOJO;
import com.sudheer.securebank.model.StatusPOJO;
import com.sudheer.securebank.service.PaymentServiceImpl;

@RestController
public class PaymentController {
	@Autowired
	private PaymentServiceImpl payimpl;
	@RequestMapping(value="/payment",method = RequestMethod.POST,consumes = "application/json")
	StatusPOJO acceptPayment(@RequestBody PaymentPOJO dto)
	{
		PaymentEntity  dao = new PaymentEntity();
		BeanUtils.copyProperties(dto, dao);
		StatusPOJO resdao= payimpl.doPaymentSer(dao);
		return resdao;
		
	}
	

}
