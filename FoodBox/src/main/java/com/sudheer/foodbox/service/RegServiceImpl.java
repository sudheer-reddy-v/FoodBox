package com.sudheer.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.foodbox.entity.LoginPOJO;
import com.sudheer.foodbox.entity.LoginStatusPOJO;
import com.sudheer.foodbox.entity.RegistrationPOJO;
import com.sudheer.foodbox.entity.VendorDetailsPOJO;
import com.sudheer.foodbox.model.StatusModel;
import com.sudheer.foodbox.repo.Regrepo;
import com.sudheer.foodbox.repo.VendorRepo;

@Service
public class RegServiceImpl implements RegService {
	@Autowired
	private Regrepo regrepo;
	@Autowired
	private VendorRepo vrepo;

	LoginStatusPOJO lresdao= new LoginStatusPOJO();
	
	@Override
	public StatusModel doRegService(RegistrationPOJO dao) {
		StatusModel resdao=new StatusModel();
	boolean b=regrepo.existsById(dao.getPhno());
	if(b)
	{
		resdao.setErrorcode(601);
		resdao.setErrorMsg("user aredy exist");
		return resdao;
	}
	else
	{
		regrepo.save(dao);
		resdao.setErrorcode(200);
		resdao.setErrorMsg("successfully registered");
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
			lresdao.setErrorcode(602);
			lresdao.setErrormsg("bad cridentials");
			return lresdao;
		}
		
	}

}
