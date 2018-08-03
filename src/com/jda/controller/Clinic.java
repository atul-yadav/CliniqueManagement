package com.jda.controller;

import java.util.ArrayList;
import java.util.List;

import com.jda.model.Appointment;
import com.jda.model.Doctor;
import com.jda.model.Patient;
import com.jda.services.AddDetails;
import com.jda.services.DisplayDetails;
import com.jda.services.SearchDetails;
import com.jda.utility.Utility2;

public class Clinic {
	public static List<Doctor> doctorList = new ArrayList<>();
	public static List<Patient> patientList = new ArrayList<>();
	public static List<Appointment> appointmentList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Utility2 utility = new Utility2();
		AddDetails addDetails = new AddDetails();
		DisplayDetails displayDetails = new DisplayDetails();
		SearchDetails searchDetails = new SearchDetails();
		doctorList = addDetails.read(doctorList, "doctor","Doctor");
		patientList = addDetails.read(patientList, "patient", "Patient");
		appointmentList = addDetails.read(appointmentList, "appointment", "Appointment");
		int loop = 0;
		while (loop == 0) {
			System.out.println("------------------------------------------------");
			System.out.println("1. Add new person  2. Take Appointment  3. Saving  4. Show Details  5. Searching ");
			
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				boolean i = true;
				while (i) {
					System.out.println("---------------------------------------------------");
					System.out.println("1. Add doctor  2. Add Patient 3. Exit");

					int choiceAdd = utility.inputInteger();
					switch (choiceAdd) {
		
					case 1:
						doctorList = addDetails.addDoctor(doctorList);
						break;
					case 2:
						patientList = addDetails.addPatient(patientList);
						break;
					case 3:
						i = false;
						System.out.println("Closed");
						break;
					default:
						i = false;
						System.out.println("wrong happened ");
						break;
					}
				}
				break;
			case 2:
				appointmentList = addDetails.takeAppointment(doctorList,patientList,appointmentList);
				break;
			case 3:
				boolean j = true;
				while (j) {
					System.out.println("1. Saving doctor detais 2 . saving patient details 3. saving appointments  4. exit");
					int choiceSave = utility.inputInteger();
					switch (choiceSave) {
					case 1:
						addDetails.save(doctorList, "doctor");
						break;
					case 2:
						addDetails.save(patientList, "patient");
						break;
					case 3:
						addDetails.save(appointmentList, "appointment");
						break;
					case 4:
						j = false;
						System.out.println("Save Service closing");
						break;
					default:
						j = false;
						System.out.println("something wrong happened\n");
						break;
					}
				}
				break;
			case 4:
				boolean k = true;
				while (k) {
					
					System.out.println("1.Show all doctors 2. show all patients 3. show all appointments 4. show famous doctors 5 famous specialization 6. exit");
					int choiceDisplay = utility.inputInteger();
					switch (choiceDisplay) {
					case 1:
						displayDetails.printDoctor(doctorList);
						break;
					case 2:
						displayDetails.printPatient(patientList);
						break;
					case 3:
						displayDetails.printAppointment(appointmentList);
						break;
					case 4:
						displayDetails.printPopularDoctor(doctorList);
						break;
					case 5:
						displayDetails.printPopularSpecialization(doctorList);
						break;
					case 6:
						k = false;
						System.out.println("");
						break;
					default:
						k = false;
						System.out.println("something wrong happened so closing menu");
						break;
					}
				}
				break;
			case 5:
				int loopSearch = 0;
				while(loopSearch == 0) {
					
					System.out.println("1. Search Doctor  2. Search Patient   3. exit");
					int choiceSearch = utility.inputInteger();
					switch(choiceSearch) {
					case 1:
						int loopSearchDoctor = 0;
						while(loopSearchDoctor == 0) {
							
							System.out.println("-------------------------------------------------------------------------------------------------");
							System.out.println("1. Search Doctor By ID  2 Search by name 3 Search By specialization 4- search by availability 5- exit");
							int choiceSearchDoctor = utility.inputInteger();
							switch(choiceSearchDoctor) {
							case 1:
								searchDetails.searchDoctorById(doctorList);
								break;
							case 2:
								searchDetails.searchDoctorByName(doctorList);
								break;
							case 3:
								searchDetails.searchDoctorBySpecialization(doctorList);
								break;
							case 4:
								searchDetails.searchDoctorByAvailability(doctorList);
								break;
							case 5:
								loopSearchDoctor = 1;
								System.out.println("\n\t\t\tDoctor Search Service closed\n");
								break;
							default:
								loopSearchDoctor = 1;
								System.out.println("\n\t\t\tSomething went wrong\n\t\t\tDoctor Search menu closed\n");
								break;
							}
						}
						break;
					case 2:
						int loopSearchPatient = 0;
						while(loopSearchPatient == 0) {
							System.out.println("------------------------------------------------------------------------------------------------");
							System.out.println("1. Search By patient ID 2. Search By name 3- search by phone number 4 .exit");
							
							int choiceSearchPatient = utility.inputInteger();
							switch(choiceSearchPatient) {
							case 1:
								System.out.println(" ");
								searchDetails.searchPatientById(patientList);
								break;
							case 2:
								searchDetails.searchPatientByName(patientList);
								break;
							case 3:
								searchDetails.searchPatientByContact(patientList);
								break;
							case 4:
								loopSearchPatient = 1;
								System.out.println("\n\t\t\tPateint Search Service closed\n");
								break;
							default:
								loopSearchPatient = 1;
								System.out.println("\nSomething wrong happened");
								break;
							}
						}
						break;
					case 3:
						loopSearch = 1;
						System.out.println("\n\t\t\tSearch function closed\n");
						break;
						default:
							loopSearch = 1;
							System.out.println("search menu is closed");
							break;
					}
				}
				break;
			case 6:
				loop = 1;
				System.out.println("clinic closed");
				break;
			default:
				loop = 1;
				System.out.println("dhanyawad");
				break;
			}
		}
	}
}
