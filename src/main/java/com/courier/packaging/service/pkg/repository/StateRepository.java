package com.courier.packaging.service.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.packaging.service.pkg.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {
	
}