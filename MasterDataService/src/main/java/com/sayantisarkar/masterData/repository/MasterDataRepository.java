package com.sayantisarkar.masterData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sayantisarkar.masterData.model.Airport;

@Repository
public interface MasterDataRepository extends JpaRepository<Airport, Long> {
	
}
