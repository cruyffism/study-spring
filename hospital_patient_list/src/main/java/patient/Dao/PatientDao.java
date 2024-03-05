package patient.Dao;

import java.util.HashMap;
import java.util.Map;

import patient.Patient;

public class PatientDao {
	//이 HashMap은 patientDB 변수에 할당되어 사용자 정보를 저장하는 데 사용
	private Map<String, Patient> patientDB = new HashMap<String, Patient>();
	
	public void insert(Patient patient) { //insert 메소드
		patientDB.put(patient.getReservationNum(), patient);
	}
	
	public Patient select(String reservationNum) { // select(조회) 메소드
		return patientDB.get(reservationNum);
	}
	
	public void update(Patient patient) { //update 메소드
		patientDB.put(patient.getReservationNum(), patient);
	}
	
	public void delete(String reservationNum) { //delete 메소드
		patientDB.remove(reservationNum);
	}
	
	public Map<String, Patient> getPatientDB() {
		return patientDB;
	}
}
