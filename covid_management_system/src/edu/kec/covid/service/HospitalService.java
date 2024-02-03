package edu.kec.covid.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import edu.kec.covid.iservice.IHospitalService;
import edu.kec.covid.model.Hospital;

public class HospitalService implements IHospitalService{

	@Override
	public Integer findNearByHospital(Double latitude, Double longitude) {
		
		Integer hospitalId = -1;
		Integer maxDistance = 10;//to search within 10km
		LinkedList<Hospital> hospitalList = getHospitals();
		
		System.out.println(hospitalList.size()+"\thospitals found with beds availability.");
		//iterate to check nearby hospitals by passing latitude and longitude
		for(Hospital hospital: hospitalList) {
			double distance = calculateDistance(latitude,longitude, hospital.getLatitude(),hospital.getLongitude());
			System.out.println("Distance between patient and hospital with id: "+hospital.getId() +"is: "+distance);
			if(distance <= maxDistance) {
				hospitalId = hospital.getId();
				break;
			}
		}
		return hospitalId;
	}
	
	//insertion is fast for LL, duplicates are allowed
	private LinkedList<Hospital> getHospitals(){
		LinkedList<Hospital> hospitalList = new LinkedList<Hospital>();
		String sql = "SELECT a.id, a.name, a.availableBeds, b.latitude, b.longitude "
				+ "FROM (SELECT id, name, availableBeds, areaId FROM covid.hospital "
				+ "WHERE availableBeds > 0)a LEFT JOIN (SELECT id, latitude, longitude "
				+ "FROM covid.area)b ON a.areaId = b.id";
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3304/covid","root","");//java database connectivity(jdbc),DriverManager - translates
        	Statement statement = connection.createStatement();
        	ResultSet resultSet = statement.executeQuery(sql);
        	
        	while(resultSet.next()) {
        		Hospital hospital = new Hospital(resultSet.getInt("id"),resultSet.getString("name"),null,
        				                         resultSet.getInt("availableBeds"),null,resultSet.getDouble("latitude"),
        				                         resultSet.getDouble("longitude"));
        		hospitalList.add(hospital);
        	}
        }
        catch(SQLException ex) {
        	ex.printStackTrace();
        }
		return hospitalList;
	}
	
	private Double calculateDistance(Double patientLat, Double patientLong, Double hospitalLat,Double hospitalLong ) 
	{
		Double latDifference = patientLat - patientLat;
		Double longDifference = patientLong - hospitalLong;
		return  Math.sqrt(latDifference * latDifference + longDifference * longDifference);//euler's algorithm
	}
}
