package ch04_pjt_01.ems.member.service;

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentDeleteService {

	private StudentDao studentDao;

	public StudentDeleteService(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}
	
	public void delete(String sNum) {
		if (verify(sNum)) {
			studentDao.delete(sNum);
		} else {
			System.out.println("Student information is available");
		}
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false; //조회된 학생 정보가 있는 경우, 즉 학번에 해당하는 학생 정보가 데이터베이스에 있는 경우 true를 반환 아니면 false
	}
}