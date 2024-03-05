package ch06_pjt_01.ems.member.service;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentRegisterService {
	
	private StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) { //studentDao를 파라미터로 갖는 생성자
		this.studentDao = studentDao;
	}
	
	public void register(Student student) {
		if(verify(student.getsNum())) { //null이면
			studentDao.insert(student);
		} else {
			System.out.println("The student has already registered."); //null이 아니고 이미 정보가 있으면
		}
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null ? true : false;
	}
	
}
