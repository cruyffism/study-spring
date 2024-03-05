package patient.Service;

import patient.Patient;
import patient.Dao.PatientDao;

public class PatientSelectService {

	private PatientDao patientDao;

	public PatientSelectService(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public Patient select(String reservationNum) {
		if(verify(reservationNum)) {
			return patientDao.select(reservationNum);
		} else {
			System.out.println("예약번호가 존재하지 않습니다.");
		}
		return null; //reservationNum이 유효하지 않은경우, 정보를 db에서 조회할 필요가 없고 유효하지 않은 정보임을 알리기 위해 null을 반환
	}
	
	
	public boolean verify(String reservationNum) {
		Patient patient = patientDao.select(reservationNum);
		return patient != null ? true : false; 
	}
	
}
