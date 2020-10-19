package com.seveneleven.repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seveneleven.dto.Vendor;
import com.seveneleven.exception.RecordNotFoundException;
import com.seveneleven.model.VendorEntity;
 
@Repository
public class VendorRepositoryImpl {
     
    @Autowired
    VendorRepository repository;
     
    public List<VendorEntity> getAllVendors()
    {
        List<VendorEntity> vendorList = repository.findAll();
         
        if(vendorList.size() > 0) {
            return vendorList;
        } else {
            return new ArrayList<VendorEntity>();
        }
    }
     
    public VendorEntity getVendorById(Long id) throws RecordNotFoundException 
    {
        Optional<VendorEntity> vendor = repository.findById(id);
         
        if(vendor.isPresent()) {
            return vendor.get();
        } else {
            throw new RecordNotFoundException("No vendor record exist for given id");
        }
    }
     
    public VendorEntity createVendor(Vendor vendor) throws RecordNotFoundException 
    {
    	VendorEntity newEntity = new VendorEntity();
    	newEntity.setVendorName(vendor.getVendorName());
    	newEntity.setVendorAddress(vendor.getVendorAddress());
    	newEntity.setContactNumber(vendor.getContactNumber());
    	newEntity.setEmail(vendor.getEmail());
    	newEntity.setProductType(vendor.getProductType());
    	newEntity.setCreatedDate(LocalDate.now());
    	newEntity.setUpdatedDate(LocalDate.now());
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	newEntity.setEndDate(LocalDate.parse(vendor.getEndDate(),formatter));
    	newEntity.setStartDate(LocalDate.parse(vendor.getStartDate(),formatter));
    	newEntity.setRecordState(vendor.getRecordState());
        return repository.save(newEntity);
    } 
     
    public VendorEntity deleteVendorById(Long id) throws RecordNotFoundException 
    {
        Optional<VendorEntity> vendor = repository.findById(id);
         
        if(vendor.isPresent()) 
        {
            repository.deleteById(id);
            return vendor.get();
        } else {
            throw new RecordNotFoundException("No Vendor record exist for given id");
        }
    }

	public Map<String, List> updateVendors(List<Vendor> vendorsList) {
		List<VendorEntity> vendorEntities =  new ArrayList<VendorEntity>();
		List<Vendor> failedToUpdate =  new ArrayList<Vendor>();

		vendorsList.forEach(vendor -> {
			Optional<VendorEntity> existingEntity = repository.findById(vendor.getId());
			if(existingEntity.isPresent()) 
		    {
		    VendorEntity newEntity = existingEntity.get();
	    	newEntity.setVendorName(vendor.getVendorName());
	    	newEntity.setVendorAddress(vendor.getVendorAddress());
	    	newEntity.setContactNumber(vendor.getContactNumber());
	    	newEntity.setEmail(vendor.getEmail());
	    	newEntity.setProductType(vendor.getProductType());
	    	newEntity.setUpdatedDate(LocalDate.now());
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    	newEntity.setEndDate(LocalDate.parse(vendor.getEndDate(),formatter));
	    	newEntity.setStartDate(LocalDate.parse(vendor.getStartDate(),formatter));
	    	newEntity.setRecordState(vendor.getRecordState());
	    	vendorEntities.add(newEntity);
	    	}else {
	    		failedToUpdate.add(vendor);
	    	}
		});
		Map<String, List> returnObj = new HashMap<>();
		returnObj.put("updated_vendors", repository.saveAll(vendorEntities));
		returnObj.put("update_failed", failedToUpdate);
		return returnObj;
	} 
}