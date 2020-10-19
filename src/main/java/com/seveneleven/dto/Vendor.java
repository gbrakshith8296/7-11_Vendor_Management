package com.seveneleven.dto;

import java.time.LocalDate;
import java.util.UUID;


public class Vendor {
	
	private Long id;
    private String vendorName;
    private String vendorAddress;
    private String email;
    private Long contactNumber;
    private Integer productType;
    private String recordState;
    private String startDate;
    private String endDate;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getRecordState() {
		return recordState;
	}
	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vendorName=" + vendorName + ", vendorAddress=" + vendorAddress + ", email="
				+ email + ", contactNumber=" + contactNumber + ", productType=" + productType + ", recordState="
				+ recordState + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	 
	 

}
