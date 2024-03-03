package member.service;

import member.User;
import member.dao.UserDao;

public class UserModifyService {
	
	private UserDao userDao;
	
	public UserModifyService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void modify(User user) {
		if(verify(user.getUserNum())) {
			userDao.update(user);
		} else {
			System.out.println("User information is available");
		}
	}
	
	public boolean verify(String userNum) {
		User user = userDao.select(userNum);
		return user != null ? true : false;  //조회된 회원 정보가 있는 경우, 즉 학번에 해당하는 학생 정보가 데이터베이스에 있는 경우 true를 반환 아니면 false
	}
}
