package com.seveneleven.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seveneleven.model.VendorEntity;
 

 
@Repository
public interface VendorRepository 
        extends JpaRepository<VendorEntity, Long> {

	
 
}