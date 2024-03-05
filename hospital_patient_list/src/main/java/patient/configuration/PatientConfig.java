package patient.configuration;

import org.springframework.context.annotation.Bean;

import hospital.utils.InitSampleData;
import patient.Dao.PatientDao;
import patient.Service.PatientAllSelectService;
import patient.Service.PatientDeleteService;
import patient.Service.PatientModifyService;
import patient.Service.PatientRegisterService;
import patient.Service.PatientSelectService;
import patient.Service.PrintPatientInformationService;

public class PatientConfig {
	
	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
	
		String[] reservationNum = {"P001", "P002", "P003", "P004", "P005"};
		initSampleData.setReservationNum(reservationNum);
		
		String[] patientName = {"김철수", "박영희", "최불암", "이지원", "전진우"};
		initSampleData.setPatientName(patientName);
		
		String[] address = {"수원시 영통구", "수원시 권선구", "용인시 기흥구", "성남시 분당구", "서울시 동작구"};
		initSampleData.setAddress(address);
		
		String[] phone = {"010-1234-4567", "010-6548-4712", "010-5858-6363", "010-7878-8585", "010-1245-4484"};
		initSampleData.setPhone(phone);
		
		String[] email = {"kim@daum.net", "zero@gmail.com", "fire@naver.com", "jiwon@naver.com", "jinwoo@daum.net"};
		initSampleData.setEmail(email);
		
		String[] department = {"내과", "가정의학과", "노년내과", "건강의학과", "구강악안면외과"};
		initSampleData.setDepartment(department);
		
		String[] registrationNum = {"950220-1545768", "850111-2154759", "550321-1236598", "960418-2235417", "931219-1239668"};
		initSampleData.setRegistrationNum(registrationNum);
		
		String[] inputDate = {"2024-03-05", "2024-03-05", "2024-03-05", "2024-03-05", "2024-03-05"};
		initSampleData.setInputDate(inputDate);
		
		char[] gender = {'남', '여', '남', '여', '남'};
		initSampleData.setGender(gender);

		return initSampleData;
	}
	
	@Bean // 빈객체 생성
	public PatientDao patientDao() {
		return new PatientDao();
	}
	
	//생성자를 이용한 의존객체 주입
	@Bean // ..service() 이용 주입
	public PatientRegisterService patientRegisterService() {
		return new PatientRegisterService(patientDao());
	}
	
	@Bean
	public PatientModifyService patientModifyService() {
		return new PatientModifyService(patientDao());
	}
	
	@Bean
	public PatientDeleteService patientDeleteService() {
		return new PatientDeleteService(patientDao());
	}
	
	@Bean
	public PatientSelectService patientSelectService() {
		return new PatientSelectService(patientDao());
	}
	
	@Bean
	public PatientAllSelectService patientAllSelectService() {
		return new PatientAllSelectService(patientDao());
	}
	
	@Bean
	public PrintPatientInformationService printPatientInformationService() {
		return new PrintPatientInformationService(patientAllSelectService());
	}
}
