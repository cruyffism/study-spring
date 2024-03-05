package member.service;

import org.springframework.beans.factory.annotation.Autowired;

import member.User;
import member.dao.UserDao;
// user 정보를 HashMap에 저장하는 기능
public class UserRegisterService {

	@Autowired
	private UserDao userDao;
	
	public UserRegisterService(UserDao userDao) { 
		this.userDao = userDao;
	}
	
	public void register(User user) {
		if(verify(user.getUserNum())) { //null이면 회원 등록!
			userDao.insert(user);
		} else {
			System.out.println("The user has already registerd");
		}
	}
	
	public boolean verify(String userNum) {
		User user = userDao.select(userNum);
		return user == null ? true : false;
	}
}
