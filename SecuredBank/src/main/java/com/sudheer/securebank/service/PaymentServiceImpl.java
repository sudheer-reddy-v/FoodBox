package com.sudheer.securebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudheer.securebank.entity.PaymentEntity;
import com.sudheer.securebank.entity.PaymentStatusEntity;
import com.sudheer.securebank.repository.AccountRepository;

@Service
public class PaymentServiceImpl  implements PaymentService{
	@Autowired
	private AccountRepository acrepo;

	@Override
	public PaymentStatusEntity doPaymentSer(PaymentEntity dao) {
		PaymentStatusEntity resdao= new PaymentStatusEntity(); 
		double bal=acrepo.checkBal(dao.getCardno());
		if(bal==0)
		{
			resdao.setPcode(801);
			resdao.setPmsg("invallid card details");
			return resdao;
		}
		else if(bal<dao.getAmt())
		{
			resdao.setPcode(802);
			resdao.setPmsg("in sufficient balance");
		return resdao;	
		}
		else
		{
			updateBal(dao);
		resdao.setPcode(200);
		resdao.setPmsg("order placed successfully");
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


