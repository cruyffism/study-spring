package patient.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import patient.Patient;

public class PrintPatientInformationService {
	@Autowired
	PatientAllSelectService allSelectService;
	
	public PrintPatientInformationService(PatientAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	// allSelectService 객체의 allSelect() 메서드를 호출하여 모든 회원
	// 정보를 가져옵니다. 이 정보는 Map<String, Patient> 형태로 반환됩니다.
	public void printPatientInfo() {
		Map<String, Patient> allPatient = allSelectService.allSelect(); 
		
		Set<String> Keys = allPatient.keySet();
		Iterator<String> iterator = Keys.iterator();
		
		System.out.println("예약 환자 명단 ----------------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			Patient patient = allPatient.get(key);
			System.out.print("예약번호: " + patient.getReservationNum());
			System.out.print("| 환자명: " + patient.getPatientName());
			System.out.print("| 주소: " + patient.getAddress());
			System.out.print("| 전화번호: " + patient.getPhone());
			System.out.print("| 이메일: " + patient.getEmail());
			System.out.print("| 진료과: " + patient.getDepartment());
			System.out.print("| 주민등록번호: " + patient.getRegistrationNum());
			System.out.print("| 최초 입력일: " + patient.getInputDate());
			System.out.println("| 성별: " + patient.getGender());
		}
		
		System.out.println("이상 ----------------");
		System.out.println();
	}
}
