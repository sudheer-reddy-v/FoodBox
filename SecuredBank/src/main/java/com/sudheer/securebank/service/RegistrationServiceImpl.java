package com.sudheer.securebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.securebank.entity.AccountRegistrationEntity;
import com.sudheer.securebank.entity.AccountRegistrationStatusEntity;
import com.sudheer.securebank.entity.AccountEntity;
import com.sudheer.securebank.repository.AccountRepository;
@Service
public class RegistrationServiceImpl implements Registrationservice{
	@Autowired
	private AccountRepository arepo;
	@Autowired
	private RandomCardDetailsService rser;

	@Override
	public AccountRegistrationStatusEntity doRegistration(AccountRegistrationEntity dao) {
		AccountRegistrationStatusEntity resdao= new AccountRegistrationStatusEntity();
		String adao=arepo.checkAccount(dao.getPhono());
		if(!"".equals(adao) && adao!=null)
		
		{
			resdao.setSmsg("account alredyExisit");
			resdao.setStatusCode(701);
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
			resdao.setStatusCode(200);
			resdao.setSmsg("account successfully created");
			return resdao;
		}
		
	}

}
