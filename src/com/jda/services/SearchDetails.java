package com.jda.services;

import java.util.List;

import com.jda.model.Doctor;
import com.jda.model.Patient;
import com.jda.utility.Utility2;

public class SearchDetails {
	
	
		Utility2 utility = new Utility2();
		
		
		public void searchDoctorById(List<Doctor> doctorList) {
			System.out.println("Enter the Doctorid to be searched");
			long id = utility.inputInteger();
			int count = 0;
			for(Doctor doctor : doctorList) {
				if(doctor.getId()==id) {
					System.out.println(doctor.toString());
					count ++;
				}
			}
			if(count == 0) {
				System.out.println("No doctor found of this ID");
			}
		}

		
		
		public void searchDoctorByName(List<Doctor> doctorList) {
			System.out.println("Enter the name of doctor to to be searched");
			String name = utility.inputString();
			int count = 0;
			for(Doctor doctor : doctorList) {
				if(doctor.getName().equals(name)) {
					System.out.println(doctor.toString());
					count ++;
				}
			}
			if(count == 0) {
				System.out.println("No doctor found of this name");
			}
		}

		
		public void searchDoctorBySpecialization(List<Doctor> doctorList) {
			System.out.println("Enter the specialization of doctor to be search");
			String specialization = utility.inputString();
			int count = 0;
			for(Doctor doctor : doctorList) {
				if(doctor.getSpecialization().equals(specialization)) {
					System.out.println(doctor.toString());
					count ++;
				}
			}
			if(count == 0) {
				System.out.println("No doctor found of this specialization");
			}
		}
		
		public void searchDoctorByAvailability(List<Doctor> doctorList) {
			System.out.println("Search doctor by availibility");
			String availability = utility.inputString();
			int count = 0;
			for(Doctor doctor : doctorList) {
				if(doctor.getAvailability().equals(availability)) {
					System.out.println(doctor.toString());
					count ++;
				}
			}
			if(count == 0) {
				System.out.println("No doctor found on this time");
			}
		}

		
		
		public void searchPatientById(List<Patient> patientList) {
			System.out.println("Enter the patient id to be searched");
			long id = utility.inputInteger();
			int count = 0;
			for(Patient patient : patientList) {
				if(patient.getId()==id) {
					System.out.println(patient.toString());
					count++;
				}
			}
			if(count==0) {
				System.out.println("No patient found of this id");
			}
		}

		
	
		public void searchPatientByName(List<Patient> patientList) {
			System.out.println("Enter the patient name to be searched");
			String name = utility.inputString();
			int count = 0;
			for(Patient patient : patientList) {
				if(patient.getName().equals(name)) {
					System.out.println(patient.toString());
					count++;
				}
			}
			if(count==0) {
				System.out.println("No patient found of this name");
			}
		}

		
		public void searchPatientByContact(List<Patient> patientList) {
			System.out.println("Enter the phone number to be searched");
			String number = utility.inputString();
			int count = 0;
			for(Patient patient : patientList) {
				if(patient.getPhone().equals(number)) {
					System.out.println(patient.toString());
					count++;
				}
			}
			if(count==0) {
				System.out.println(" No patient found of this phone number");
			}
		}

	}


