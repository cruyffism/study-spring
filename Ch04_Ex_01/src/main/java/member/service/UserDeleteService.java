package member.service;

import member.User;
import member.dao.UserDao;

public class UserDeleteService {
	
	private UserDao userDao;

	public UserDeleteService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void delete(String userNum) {
		if(verify(userNum)) {
			userDao.delete(userNum);
		} else {
			System.out.println("User information is available");
		}
	}
	
	
	public boolean verify(String userNum) {
		User user = userDao.select(userNum);
		return user != null ? true : false;
	}
}
