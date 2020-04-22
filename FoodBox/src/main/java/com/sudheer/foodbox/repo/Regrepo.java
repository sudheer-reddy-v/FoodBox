package com.sudheer.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudheer.foodbox.entity.RegistrationPOJO;
import com.sun.xml.bind.v2.model.core.ID;

public interface Regrepo extends JpaRepository<RegistrationPOJO, Long> {
	@Query(value = "r.uname from  RegistrationDao r where r.phno=1")
String findUsername(long phone);
}
