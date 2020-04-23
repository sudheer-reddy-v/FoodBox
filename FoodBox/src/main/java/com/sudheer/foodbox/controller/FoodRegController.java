package com.sudheer.foodbox.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudheer.foodbox.entity.LoginPOJO;
import com.sudheer.foodbox.entity.LoginStatusPOJO;
import com.sudheer.foodbox.entity.RegistrationPOJO;
import com.sudheer.foodbox.model.LoginModel;
import com.sudheer.foodbox.model.LoginStatusModel;
import com.sudheer.foodbox.model.RegistrationModel;
import com.sudheer.foodbox.model.StatusModel;
import com.sudheer.foodbox.service.RegServiceImpl;

@RestController
public class FoodRegController {
	@Autowired
	private  RegServiceImpl service;
	
	@RequestMapping(value="/reqReg",method = RequestMethod.POST,consumes = "application/json")
	public StatusModel requestRegistration(@RequestBody RegistrationModel dto)
	{
		RegistrationPOJO dao= new RegistrationPOJO();
		BeanUtils.copyProperties(dto, dao);
		StatusModel resdao=service.doRegService(dao);
		return resdao;
		
	}
	@RequestMapping(value="/dologin",method = RequestMethod.POST,consumes = "application/json")
public LoginStatusModel doLogin(@RequestBody LoginModel dto)
{
	LoginPOJO dao=new LoginPOJO(); 
	BeanUtils.copyProperties(dto, dao);
	LoginStatusPOJO lresdao=service.doLoginService(dao);
	//RegresDto resdto= new RegresDto();
	LoginStatusModel lresdto= new LoginStatusModel();
	
	BeanUtils.copyProperties(lresdao, lresdto);
	
	return lresdto;
	
}
}
