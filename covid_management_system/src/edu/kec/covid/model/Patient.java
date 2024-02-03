package edu.kec.covid.model;

public class Patient {
	private Integer id;
	private String name;
	private Long aadharId;
	private Integer areaId;
	private Integer hospitalId;
	private String status;
	
	//creating constructors
	public Patient(Integer id, String name, Long aadharId, Integer areaId, String status, Integer hospitalId) {
		super();
		this.id = id;
		this.name = name;
		this.aadharId = aadharId;
		this.areaId = areaId;
		this.status = status;
		this.hospitalId = hospitalId;
	}
	
	//creating getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAadharId() {
		return aadharId;
	}
	public void setAadharId(Long aadharId) {
		this.aadharId = aadharId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	
}
