package com.sudheer.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudheer.foodbox.entity.MenuDetailsPOJO;

public interface MenuRepository extends JpaRepository<MenuDetailsPOJO, Integer>{ 

	@Query(value = "select m.price from MenuDetailsPOJO m where m.menuId=1")
	String findPrice(int itemid);
}
