package ch04_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ch04_pjt_01.ems.member.Student;

public class StudentDao {
	
    private Map<String, Student> studentDB = new HashMap<String, Student>();  	//HashMap을 통해 데이터를 가져온다.
    
    public void insert(Student student) { //insert 메소드 >> student는 새로 추가 된 데이터
    	studentDB.put(student.getsNum(), student);
    }
    
    public Student select(String sNum) {  //select(조회) 메소드 >> sNum을 갖고 있는 학생의 정보를 리턴해준다.
    	return studentDB.get(sNum);
    }
    
    public void update(Student student) {  //update 메소드에서 student는 기존 데이터를 최신화한 데이터!
    	studentDB.put(student.getsNum(), student);
    }
    
    public void delete(String sNum) {//delete 메소드
    	studentDB.remove(sNum);
    }
    
    public Map<String, Student> getStudentDB() { //
    	return studentDB;
    }
}
