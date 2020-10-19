package com.seveneleven.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.seveneleven.dto.Vendor;
import com.seveneleven.exception.RecordNotFoundException;
import com.seveneleven.model.VendorEntity;

public interface VendorService {

	List<VendorEntity> getAllVendors();

	VendorEntity deleteVendorById(Long id) throws RecordNotFoundException;

	VendorEntity createVendor(Vendor vendor) throws RecordNotFoundException;

	VendorEntity getvendorById(Long id) throws RecordNotFoundException;

	Map<String, List> updateVendors(List<Vendor> vendorsList);

}
