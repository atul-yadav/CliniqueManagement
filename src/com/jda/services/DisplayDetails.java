package com.jda.services;

import java.util.List;

import com.jda.model.Appointment;
import com.jda.model.Doctor;
import com.jda.model.Patient;

public class DisplayDetails {
	
	
	
	
	
	public void printPatient(List<Patient> patientList) {
		for(Patient patient: patientList) {
			System.out.println(patient.toString());
		}
	}

		
		public void printDoctor(List<Doctor> doctorList) {
			for(Doctor doctor : doctorList) {
				System.out.println(doctor.toString());
			}
		}

	
		public void printAppointment(List<Appointment> appointmentList) {
			for(Appointment appointment : appointmentList) {
				System.out.println(appointment.toString());
			}
		}

		
		public void printPopularDoctor(List<Doctor> doctorList) {
			for(Doctor doctor : doctorList) {
				if(doctor.getNumberOfPatients() == 5) {
					System.out.println("Popular doctor is"+doctor.getName());
				}
			}
		}

		
		public void printPopularSpecialization(List<Doctor> doctorList) {
			for(Doctor doctor : doctorList) {
				if(doctor.getNumberOfPatients()==5) {
					System.out.println("famous specialization is"+doctor.getSpecialization());
				}
			}
		}
	}



