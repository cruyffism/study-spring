package center;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hospital.utils.InitSampleData;
import patient.Patient;
import patient.Service.PatientDeleteService;
import patient.Service.PatientModifyService;
import patient.Service.PatientRegisterService;
import patient.Service.PatientSelectService;
import patient.Service.PrintPatientInformationService;
import patient.configuration.PatientConfig;

public class MainClass {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(PatientConfig.class);
		
		//샘플 데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
	
		String[] reservationNum = initSampleData.getReservationNum();
		String[] patientName = initSampleData.getPatientName();
		String[] address =	initSampleData.getAddress();	
		String[] phone = initSampleData.getPhone();
		String[] email = initSampleData.getEmail();
		String[] department = initSampleData.getDepartment();
		String[] registrationNum = initSampleData.getRegistrationNum();
		String[] inputDate = initSampleData.getInputDate();
		char[] gender = initSampleData.getGender();

		//db에 샘플 등록
		PatientRegisterService registerService = ctx.getBean("patientRegisterService", PatientRegisterService.class);
		for(int i=0; i < reservationNum.length; i++) {
			registerService.register(
					new Patient(patientName[i], address[i], phone[i], email[i], department[i], registrationNum[i], reservationNum[i], inputDate[i], gender[i]));
		}
		
		//환자 리스트
		PrintPatientInformationService printPatientInformationService = 
				ctx.getBean("printPatientInformationService", PrintPatientInformationService.class);
		printPatientInformationService.printPatientInfo();
		
		//환자 등록
		registerService = ctx.getBean("patientRegisterService", PatientRegisterService.class);
		registerService.register(new Patient("유재민", "부산시 사하구", "010-8525-6620", "you@naver.com", "내과", "910521-1345268",
				"P006", "2024-03-06", 'M' ));
		
		//환자 출력
		PatientSelectService selectService = ctx.getBean("patientSelectService", PatientSelectService.class);
		Patient selectedPatient  = selectService.select("P006");
		
		
		System.out.println("새로운 환자 명단 ----------------");
		System.out.print("예약번호: " + selectedPatient.getReservationNum());
		System.out.print("| 환자명: " + selectedPatient.getPatientName());
		System.out.print("| 주소: " + selectedPatient.getAddress());
		System.out.print("| 전화번호: " + selectedPatient.getPhone());
		System.out.print("| 이메일: " + selectedPatient.getEmail());
		System.out.print("| 진료과: " + selectedPatient.getDepartment());
		System.out.print("| 주민등록번호: " + selectedPatient.getRegistrationNum());
		System.out.print("| 최초 입력일: " + selectedPatient.getInputDate());
		System.out.println("| 성별: " + selectedPatient.getGender());
		System.out.println("이상 ----------------");
		System.out.println();
		
		printPatientInformationService.printPatientInfo();
		
		//환자 정보 수정
		PatientModifyService modifyService = ctx.getBean("patientModifyService", PatientModifyService.class);
		modifyService.modify(new Patient("조형선", "서울시 강남구", "010-4717-6620", "cho@naver.com", "외과", "940530-2145228", "P006", "2024-03-06", 'F' ));
		
		System.out.println("환자 정보 업데이트 >> P006");
		printPatientInformationService.printPatientInfo(); //환자 리스트
		
		//환자 삭제
		PatientDeleteService deleteService = ctx.getBean("patientDeleteService", PatientDeleteService.class);
		deleteService.delete("P004");
		
		System.out.println("환자 1명 삭제 >> P004");
		printPatientInformationService.printPatientInfo(); //환자 리스트
		
		ctx.close(); 
		
	}

}
