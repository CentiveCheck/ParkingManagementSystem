package com.parkingpspacemanagement.models;

public class Vehicle {

	private String licenseNumber;
	private Long entryTime;
	private Long exitTime;
	private Double parkingFees;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Long getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Long entryTime) {
		this.entryTime = entryTime;
	}

	public Long getExitTime() {
		return exitTime;
	}

	public void setExitTime(Long exitTime) {
		this.exitTime = exitTime;
	}

	public Double getParkingFees() {
		return parkingFees;
	}

	public void setParkingFees(Double parkingFees) {
		this.parkingFees = parkingFees;
	};

}
