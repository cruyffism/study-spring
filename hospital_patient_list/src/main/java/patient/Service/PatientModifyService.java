package patient.Service;

import org.springframework.beans.factory.annotation.Autowired;

import patient.Patient;
import patient.Dao.PatientDao;

public class PatientModifyService {
	@Autowired
	private PatientDao patientDao;

	public PatientModifyService(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public void modify(Patient patient) {
		if(verify(patient.getReservationNum())) {
			patientDao.update(patient);
		} else {
			System.out.println("예약번호가 존재하지 않습니다.");
		}
	}
	
	public boolean verify(String reservationNum) {
		Patient patient = patientDao.select(reservationNum);
		return patient != null ? true : false;
	}
}
