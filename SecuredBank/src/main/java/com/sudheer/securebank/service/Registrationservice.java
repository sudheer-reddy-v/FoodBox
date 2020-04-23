package com.sudheer.securebank.service;

import com.sudheer.securebank.entity.AccountRegistrationEntity;
import com.sudheer.securebank.model.StatusPOJO;

public interface Registrationservice {
	public StatusPOJO doRegistration(AccountRegistrationEntity dao);

}
