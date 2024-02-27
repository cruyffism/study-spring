package ch04_pjt_01.ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch04_pjt_01.ems.member.Student;

public class PrintStudentInformationService { //전체 학생 정보 출력

	StudentAllSelectService allSelectService;
	
	public PrintStudentInformationService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	public void printStudentInfo() {
		Map<String, Student> allStudent = allSelectService.allSelect(); //allSelectService 객체의 allSelect() 메서드를 호출하여 모든 학생 정보를 가져옵니다. 이 정보는 Map<String, Student> 형태로 반환됩니다.
		Set<String> keys = allStudent.keySet(); // set에는 순서가 없이  key, value가 존재!
		Iterator<String> iterator = keys.iterator(); // 컨테이너, 특히 리스트를 순화할 수 있게 해주는 객체
		System.out.println("STUDENT LIST START ----------------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			Student	student = allStudent.get(key);
			System.out.println("sNum:" + student.getsNum() + "\t");
			System.out.println("|sId:" + student.getsId() + "\t");
			System.out.println("|sPw:" + student.getsPw() + "\t");
			System.out.println("|sName:" + student.getsName() + "\t");
			System.out.println("|sAge:" + student.getsAge() + "\t");
			System.out.println("|sGender:" + student.getsGender() + "\t");
			System.out.println("|sMajor:" + student.getsMajor() + "\t");			
		}
		
		System.out.println("END ----------------");
	}
}
