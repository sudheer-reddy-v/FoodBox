package com.sudheer.foodbox.service;

import com.sudheer.foodbox.entity.LoginPOJO;
import com.sudheer.foodbox.entity.LoginStatusPOJO;
import com.sudheer.foodbox.entity.RegistrationPOJO;
import com.sudheer.foodbox.entity.RegistrationStatusPOJO;

public interface RegService {
	RegistrationStatusPOJO doRegService(RegistrationPOJO dao);
	LoginStatusPOJO doLoginService(LoginPOJO dao);


}
