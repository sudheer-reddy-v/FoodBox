package com.sudheer.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.foodbox.entity.LoginPOJO;
import com.sudheer.foodbox.entity.LoginStatusPOJO;
import com.sudheer.foodbox.entity.RegistrationPOJO;
import com.sudheer.foodbox.entity.RegistrationStatusPOJO;
import com.sudheer.foodbox.entity.VendorDetailsPOJO;
import com.sudheer.foodbox.repo.Regrepo;
import com.sudheer.foodbox.repo.VendorRepo;

@Service
public class RegServiceImpl implements RegService {
	@Autowired
	private Regrepo regrepo;
	@Autowired
	private VendorRepo vrepo;

	RegistrationStatusPOJO resdao = new RegistrationStatusPOJO();
	LoginStatusPOJO lresdao= new LoginStatusPOJO();
	
	@Override
	public RegistrationStatusPOJO doRegService(RegistrationPOJO dao) {
	boolean b=regrepo.existsById(dao.getPhno());
	if(b)
	{
		resdao.setErrorcode(601);
		resdao.setErrormsg("user aredy exist");
		return resdao;
	}
	else
	{
		regrepo.save(dao);
		resdao.setErrorcode(200);
		resdao.setErrormsg("successfully registered");
		return resdao;	
	}
	
		
	}
	@Override
	public LoginStatusPOJO doLoginService(LoginPOJO dao) {
		boolean b=regrepo.existsById(dao.getPhno());
		if(b)
		{
			lresdao.setErrorcode(200);
			lresdao.setErrormsg("successfully login");
			List<VendorDetailsPOJO> vlist=vrepo.findAll();
			lresdao.setVendors(vlist);
			return lresdao;
		}
		else
		{
			resdao.setErrorcode(602);
			resdao.setErrormsg("bad cridentials");
			return lresdao;
		}
		
	}

}
