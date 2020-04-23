package com.sudheer.securebank.service;

import com.sudheer.securebank.entity.PaymentEntity;
import com.sudheer.securebank.model.StatusPOJO;

public interface PaymentService {
	StatusPOJO doPaymentSer(PaymentEntity dao);
	

}
