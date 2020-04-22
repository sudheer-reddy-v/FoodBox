package com.sudheer.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudheer.foodbox.entity.VendorDetailsPOJO;

public interface VendorRepo  extends JpaRepository<VendorDetailsPOJO, Integer>{

}
