package edu.kec.covid.model;

public class Hospital {
	private Integer id;
	private String name;
	private Integer areaId;
	private Integer availableBeds;
	private Double latitude;
	private Double longitude;
	public Hospital(Integer id, String name, Integer areaId, Integer availableBeds, Double latitude, Double longitude, double d) {
		super();
		this.id = id;
		this.name = name;
		this.areaId = areaId;
		this.availableBeds = availableBeds;
		this.latitude = latitude;
		this.longitude = longitude;
	}
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
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getAvailableBeds() {
		return availableBeds;
	}
	public void setAvailableBeds(Integer availableBeds) {
		this.availableBeds = availableBeds;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
