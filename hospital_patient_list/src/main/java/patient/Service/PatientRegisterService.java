package patient.Service;

import patient.Patient;
import patient.Dao.PatientDao;

//환자 정보를 HashMap에 저장하는 기능
public class PatientRegisterService {
	private PatientDao patientDao;

	public PatientRegisterService(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public void register (Patient patient) {
		if(verify(patient.getReservationNum())) {
			patientDao.insert(patient);
		} else {
			System.out.println("이미 예약된 환자 입니다.");
		}
	}
	
	public boolean verify(String reservationNum) {
		Patient patient = patientDao.select(reservationNum);
		return patient == null ? true : false;
	}
}
