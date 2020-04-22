package com.sudheer.securebank.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.securebank.entity.PaymentEntity;
import com.sudheer.securebank.entity.PaymentStatusEntity;
import com.sudheer.securebank.model.PaymentPOJO;
import com.sudheer.securebank.model.PaymentStatusPOJO;
import com.sudheer.securebank.service.PaymentServiceImpl;

@RestController
public class PaymentController {
	@Autowired
	private PaymentServiceImpl payimpl;
	@RequestMapping(value="/pay",method = RequestMethod.POST,consumes = "application/json")
	PaymentStatusPOJO acceptPayment(@RequestBody PaymentPOJO dto)
	{
		PaymentEntity  dao = new PaymentEntity();
		BeanUtils.copyProperties(dto, dao);
		PaymentStatusEntity resdao= payimpl.doPaymentSer(dao);
		PaymentStatusPOJO resdto= new PaymentStatusPOJO();
		BeanUtils.copyProperties(resdao, resdao);
		return resdto;
		
	}
	

}
