package com.sudheer.securebank.service;

import com.sudheer.securebank.entity.PaymentEntity;
import com.sudheer.securebank.entity.PaymentStatusEntity;

public interface PaymentService {
	PaymentStatusEntity doPaymentSer(PaymentEntity dao);
	

}
