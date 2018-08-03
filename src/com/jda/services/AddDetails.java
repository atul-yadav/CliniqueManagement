package com.jda.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.jda.model.Appointment;
import com.jda.model.Doctor;
import com.jda.model.Patient;
import com.jda.utility.Utility2;



public class AddDetails {

	Utility2 utility = new Utility2();
	ObjectMapper mapper = new ObjectMapper();

	
	public List<Patient> addPatient(List<Patient> patientList) {
		patientList.add(utility.addPatientToList());
		return patientList;
	}
	
	
	public List<Doctor> addDoctor(List<Doctor> doctorList) {
		doctorList.add(utility.addDoctorToList());
		return doctorList;
	}


	public List<Appointment> takeAppointment(List<Doctor> doctorList, List<Patient> patientList,List<Appointment> appointmentList) {
		appointmentList.add(utility.addAppointmentToList(doctorList, patientList));
		return appointmentList;
	}

	
	public <T> void save(List<T> T, String file) {
		try {
			mapper.writeValue(new File("input/" + file + ".json"), T);
			System.out.println("file Saved");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public <T> List<T> read(List<T> T, String file, String model) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input/" + file + ".json"));
			String arrayToJson;
			if ((arrayToJson = reader.readLine()) != null) {
				if(model.equals("Doctor")) {
					TypeReference<ArrayList<Doctor>> type = new TypeReference<ArrayList<Doctor>>() {};
					T = objectMapper.readValue(arrayToJson, type);
				}
				else if(model.equals("Patient")) {
					TypeReference<ArrayList<Patient>> type = new TypeReference<ArrayList<Patient>>() {};
					T = objectMapper.readValue(arrayToJson, type);
				}
				else if(model.equals("Appointment")) {
					TypeReference<ArrayList<Appointment>> type = new TypeReference<ArrayList<Appointment>>() {};
					T = objectMapper.readValue(arrayToJson, type);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return T;
	}

}
