package com.sudheer.securebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.securebank.entity.AccountEntity;
import com.sudheer.securebank.entity.AccountRegistrationEntity;
import com.sudheer.securebank.model.StatusPOJO;
import com.sudheer.securebank.repository.AccountRepository;
@Service
public class RegistrationServiceImpl implements Registrationservice{
	@Autowired
	private AccountRepository arepo;
	@Autowired
	private RandomCardDetailsService rser;

	@Override
	public StatusPOJO doRegistration(AccountRegistrationEntity dao) {
		StatusPOJO resdao= new StatusPOJO();
		String adao=arepo.checkAccount(dao.getPhono());
		if(!"".equals(adao) && adao!=null)
		
		{
			resdao.setErrormsg("Account alredy exisit");
			resdao.setErrCode(701);
			return resdao;
		}
		else
		{
			AccountEntity dao1= new AccountEntity();
			dao1.setAccno(rser.genAccountNumber());
			dao1.setPhno(dao.getPhono());
			dao1.setCardno(rser.genCardNumber());
			dao1.setCvv(rser.genCvv());
			dao1.setBal(10000);
			dao1.setName(dao.getUname());
			arepo.save(dao1);
			resdao.setErrCode(200);
			resdao.setErrormsg("Acoount generated,details will be sent shortly");
			return resdao;
		}
		
	}

}
