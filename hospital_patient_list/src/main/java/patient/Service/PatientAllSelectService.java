package patient.Service;

import java.util.Map;

import patient.Patient;
import patient.Dao.PatientDao;

public class PatientAllSelectService {
	
	private PatientDao patientDao;

	public PatientAllSelectService(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public Map<String, Patient> allSelect() {
		return patientDao.getPatientDB();
	}
	
}
