package ch04_pjt_01.ems.member.service;

import java.util.Map;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService { // 전체 학생 정보를 조회하는 클래스
	
	private StudentDao studentDao;

	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() { // key값 : 예를 들어 1, 2, 3, 4,... 이면 value값:  1번 학생의 학번,아이디,이름 등등.. 2번 학생의 학번, 아이디, 이름 
		return studentDao.getStudentDB();
	}
	
}
