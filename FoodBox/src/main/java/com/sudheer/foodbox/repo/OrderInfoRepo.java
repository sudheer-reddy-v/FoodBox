package com.sudheer.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudheer.foodbox.entity.OrderDetailsPOJO;

public interface OrderInfoRepo extends JpaRepository<OrderDetailsPOJO, Integer>{

}
