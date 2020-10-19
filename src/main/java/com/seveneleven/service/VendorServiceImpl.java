package com.seveneleven.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.seveneleven.dto.Vendor;
import com.seveneleven.exception.RecordNotFoundException;
import com.seveneleven.model.VendorEntity;
import com.seveneleven.repository.VendorRepositoryImpl;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepositoryImpl vendorRepositoryrepo;

	@Override
	public List<VendorEntity> getAllVendors() {
		return vendorRepositoryrepo.getAllVendors();
	}

	@Override
	public VendorEntity deleteVendorById(Long id) throws RecordNotFoundException {
		return vendorRepositoryrepo.deleteVendorById(id);
	}

	@Override
	public VendorEntity createVendor(Vendor vendor) throws RecordNotFoundException {
		return vendorRepositoryrepo.createVendor(vendor);
	}

	@Override
	public VendorEntity getvendorById(Long id) throws RecordNotFoundException {
		return vendorRepositoryrepo.getVendorById(id);
	}

	@Override
	public Map<String, List> updateVendors(List<Vendor> vendorsList) {
		
		return vendorRepositoryrepo.updateVendors(vendorsList);
	}
	

	

}
