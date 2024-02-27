package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentSelectService { //학생 1명 조회하는 클래스
	
	private StudentDao studentDao;

	public StudentSelectService(StudentDao studentDao) {
		
		this.studentDao = studentDao;
	}
	
	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum); //학생 정보가 유효할 시 studentDao.select(sNum)을 호출하여 주어진 학번에 해당하는 학생 정보를 데이터베이스에서 조회
		} else {
			System.out.println("Student information is available");
		}
		
		return null;
		
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false; //조회된 학생 정보가 있는 경우, 즉 학번에 해당하는 학생 정보가 데이터베이스에 있는 경우 true를 반환 아니면 false
	}
}
