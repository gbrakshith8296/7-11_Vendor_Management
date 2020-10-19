package com.seveneleven.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="TBL_VENDORS")
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="vendor_name")
    private String vendorName;
    
    @Column(name="vendor_address")
    private String vendorAddress;
    
    @Column(name="email", nullable=false, length=200)
    private String email;
    
    @Column(name="contact_number", length = 10)
    private Long contactNumber;
    
    @Column(name="product_type")
    private Integer productType;
    
    @Column(name="record_state")
    private String recordState;
    
    @Column(name="startDate")
    private LocalDate startDate;
    
    @Column(name="endDate")
    private LocalDate endDate;
    
	@Column(name="createdDate")
    private LocalDate createdDate;
    
    @Column(name="updatedDate")
    private LocalDate updatedDate;
    
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
    
	@Override
	public String toString() {
		return "VendorEntity [id=" + id + ", vendorName=" + vendorName + ", vendorAddress=" + vendorAddress + ", email="
				+ email + ", contactNumber=" + contactNumber + ", productType=" + productType + ", recordState="
				+ recordState + ", startDate=" + startDate + ", endDate=" + endDate + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}