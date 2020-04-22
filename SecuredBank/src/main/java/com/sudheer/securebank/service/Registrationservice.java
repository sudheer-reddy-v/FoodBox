package com.sudheer.securebank.service;

import com.sudheer.securebank.entity.AccountRegistrationEntity;
import com.sudheer.securebank.entity.AccountRegistrationStatusEntity;
import com.sudheer.securebank.model.AccountRegStatusPOJO;

public interface Registrationservice {
	public AccountRegistrationStatusEntity doRegistration(AccountRegistrationEntity dao);

}
