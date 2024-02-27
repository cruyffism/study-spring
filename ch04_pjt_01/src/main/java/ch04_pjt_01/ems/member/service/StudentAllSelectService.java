package ch04_pjt_01.ems.member.service;

import java.util.Map;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService { // 전체 학생 정보를 조회하는 클래스
	
	private StudentDao studentDao;

	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
	
}
