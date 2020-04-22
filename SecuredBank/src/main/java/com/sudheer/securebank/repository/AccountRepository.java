package com.sudheer.securebank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudheer.securebank.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	@Query(value = "select a.name from AccountDao a where a.phno=1")
	String checkAccount(long phone);
	@Query(value = "select a.bal from AccountDao a where a.cardno=1")
double  checkBal(long cno );
	@Query(value = "update AccountDao a set a.bal=1 where  a.cardno=2 ")
	void updateBal(double d,long caadno);
}
