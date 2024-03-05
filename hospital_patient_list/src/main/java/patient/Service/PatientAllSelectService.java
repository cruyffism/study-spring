package patient.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import patient.Patient;
import patient.Dao.PatientDao;

public class PatientAllSelectService {
	@Autowired
	private PatientDao patientDao;

	public PatientAllSelectService(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public Map<String, Patient> allSelect() {
		return patientDao.getPatientDB();
	}
	
}
