package com.sudheer.securebank.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.securebank.model.AccountRegistrationPOJO;
import com.sudheer.securebank.entity.AccountRegistrationEntity;
import com.sudheer.securebank.entity.AccountRegistrationStatusEntity;
import com.sudheer.securebank.model.AccountRegStatusPOJO;
import com.sudheer.securebank.service.RegistrationServiceImpl;

@RestController
public class AccountRegistrationController {
	@Autowired
	private RegistrationServiceImpl rsimpl;
	@RequestMapping(value = "/reqRegistration",method = RequestMethod.POST,consumes = "application/json")
	AccountRegStatusPOJO doReg(@RequestBody AccountRegistrationPOJO dto)
	{
		AccountRegistrationEntity dao= new AccountRegistrationEntity();
		BeanUtils.copyProperties(dto, dao);
		AccountRegistrationStatusEntity resdao=rsimpl.doRegistration(dao);
		AccountRegStatusPOJO resdto= new AccountRegStatusPOJO();
		BeanUtils.copyProperties(resdao, resdto);
	return	resdto;
		
		
		
	}

}
