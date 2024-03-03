package member.dao;

import java.util.HashMap;
import java.util.Map;

import member.User;

// dao: Service와 DB를 연결하는 역할, 실제로 db에 접근해서 data 관련 CRUD 기능을 수행
public class UserDao {
	
	private Map<String, User> userDB = new HashMap<String, User>(); //이 HashMap은 userDB 변수에 할당되어 사용자 정보를 저장하는 데 사용
	
	public void insert(User user) { // insert 메소드
		userDB.put(user.getUserNum(), user);
	}
	
	public User select(String userNum) { // select(조회) 메소드 >> userNum을 갖고있는 회원의 정보를 리턴
		return userDB.get(userNum);
	}
	
	public void update(User user) { ////update 메소드에서 user는 기존 데이터를 최신화한 데이터!
		userDB.put(user.getUserNum(), user);
	}
	
	
	public void delete(String userNum) { //delete 메소드
		userDB.remove(userNum);
	}
	
	public Map<String, User> getUserDB() { // 메서드 호출 시 사용자 데이터 베이스에 대한 정보 얻음?
		return userDB;
	}
}
