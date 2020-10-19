package com.seveneleven.controller;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.dto.Vendor;
import com.seveneleven.exception.RecordNotFoundException;
import com.seveneleven.model.VendorEntity;
import com.seveneleven.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController 
{
   @Autowired
   private VendorService vendorService;
    
    @GetMapping
    public ResponseEntity<List<VendorEntity>> getAllVendors() {
        List<VendorEntity> list = vendorService.getAllVendors();
        
        return new ResponseEntity<List<VendorEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<VendorEntity> getvendorById(@PathVariable("id") Long id) 
                                                    throws RecordNotFoundException {
        VendorEntity entity = vendorService.getvendorById(id);
 
        return new ResponseEntity<VendorEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping("/addVendor")
    public ResponseEntity<VendorEntity> createVendor(@RequestBody Vendor vendor)
                                                    throws RecordNotFoundException {
        VendorEntity updated = vendorService.createVendor(vendor);
        return new ResponseEntity<VendorEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping("/updateVendors")
    public ResponseEntity<Map<String, List>> updateVendors(@RequestBody List<Vendor> vendorsList){
    	Map<String, List> vendors = vendorService.updateVendors(vendorsList);
    	
        return new ResponseEntity<Map<String, List>>(vendors, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendorById(@PathVariable("id") Long id) throws RecordNotFoundException {
    	VendorEntity vendor = vendorService.deleteVendorById(id);
    	if (vendor!=null) {
    		return new ResponseEntity<String>("Vendor deleted Successfully", new HttpHeaders(), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<String>("Failed to delete Vendor", new HttpHeaders(), HttpStatus.NO_CONTENT);
    	}
    }
}