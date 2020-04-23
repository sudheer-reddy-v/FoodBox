package com.sudheer.securebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.securebank.entity.PaymentEntity;
import com.sudheer.securebank.model.StatusPOJO;
import com.sudheer.securebank.repository.AccountRepository;

@Service
public class PaymentServiceImpl  implements PaymentService{
	@Autowired
	private AccountRepository acrepo;

	@Override
	public StatusPOJO doPaymentSer(PaymentEntity dao) {
		StatusPOJO resdao= new StatusPOJO(); 
		double bal=acrepo.checkBal(dao.getCardno());
		if(bal==0)
		{
			resdao.setErrCode(16);
			resdao.setErrormsg("Invallid card details");
			return resdao;
		}
		else if(bal<dao.getAmt())
		{
			resdao.setErrCode(14);
			resdao.setErrormsg("Insufficient balance");
		return resdao;	
		}
		else
		{
			updateBal(dao);
		resdao.setErrCode(200);
		resdao.setErrormsg("Order placed successfully");
		return resdao;
		}
	}
		public void updateBal(PaymentEntity dao)
		{
			double bal=acrepo.checkBal(dao.getCardno());
			double finalbal=bal-dao.getAmt();
			acrepo.updateBal(finalbal, dao.getCardno());
		}
	}


