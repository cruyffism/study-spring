package member.service;

import java.util.Map;

import member.User;
import member.dao.UserDao;

public class UserAllSelectService { // 전체 회원을 조회하는 클래스

	private UserDao userDao;

	public UserAllSelectService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public Map<String, User> allSelect() { // key값 : 예를 들어 1, 2, 3, 4,... 이면 value값:  1번 회원의 번호,아이디,이름 등등.. 2번 회원의 번호, 아이디, 이름 
		return userDao.getUserDB();
	}

}
