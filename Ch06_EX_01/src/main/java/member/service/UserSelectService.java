package member.service;

import org.springframework.beans.factory.annotation.Autowired;

import member.User;
import member.dao.UserDao;

public class UserSelectService {
	@Autowired
	private UserDao userDao;

	public UserSelectService(UserDao userDao) {
		this.userDao = userDao;
	}

	public User select(String userNum) {
		if (verify(userNum)) { // null이 아니면
			return userDao.select(userNum); // 회원 정보가 유효할 시 userDao.select(userNum)을 호출하여 주어진 번호에 해당하는 회원 정보를 db에서 조회
		} else {
			System.out.println("User information is available");
		}
		return null; // userNum이 유효하지 않은경우, 회원 정보를 db에서 조회할 필요가 없고 유효하지 않은 정보임을 알리기 위해 null을 반환

	}

	public boolean verify(String userNum) {
		User user = userDao.select(userNum);
		return user != null ? true : false; // 조회된 회원 정보가 있는 경우, 즉 회원번호에 해당하는 회원 정보가 db에 있는 경우 true를 반환 아니면 false
	}
}
