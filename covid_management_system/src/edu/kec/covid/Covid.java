package edu.kec.covid;

import java.util.Random;
import java.util.Scanner;

import edu.kec.covid.iservice.IHospitalService;
import edu.kec.covid.model.Patient;
import edu.kec.covid.service.HospitalService;

public class Covid {

	public static void main(String[] args) {
		IHospitalService hospitalService = new HospitalService();
		
		Scanner sc = new Scanner(System.in);
		//read patient data
		//Patient patient = new Patient();
		
		System.out.println("enter your name: ");
		String name = sc.nextLine();
		
		System.out.println("\nenter your aadharid: ");
		Long aadharId = sc.nextLong();
		
		System.out.println("\nenter latitude: ");
		Double latitude = sc.nextDouble();
		
		System.out.println("\nenter longitude: ");
		Double longitude = sc.nextDouble();
		
		//generate a random num,check the condition , if it is >5 positive else negative
		Random random = new Random();
		boolean isPositive = (random.nextInt(1,10)>5)?true:false;
		
		if(isPositive)//random.nextBoolean or true
		{
			System.out.println("Patient is positive");
			Integer hospitalId = hospitalService.findNearByHospital(latitude, longitude);
			if(hospitalId>0) {
				System.out.println("Found hospital");
			}
			else {
				System.out.println("Hospital not found in your area");
			}
		}
		else
		{
			System.out.println("Patient is negative");
		}
			 

	}

}
