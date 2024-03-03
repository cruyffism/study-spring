package member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import member.User;

public class PrintUserInformationService { //전체 회원 정보 출력
	
	UserAllSelectService allSelectService;
	
	public PrintUserInformationService(UserAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}
	
	public void printUserInfo() {
		Map<String, User> allUser = allSelectService.allSelect(); //allSelectService 객체의 allSelect() 메서드를 호출하여 모든 회원 정보를 가져옵니다. 이 정보는 Map<String, User> 형태로 반환됩니다.
		Set<String> Keys = allUser.keySet(); // set에는 순서가 없이  key, value가 존재!
		Iterator<String> iterator = Keys.iterator(); // 컨테이너, 특히 리스트를 순화할 수 있게 해주는 객체
		System.out.println("STUDENT LIST START ----------------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			User user = allUser.get(key);
			System.out.println("userNum" + user.getUserNum() + "\t");
			System.out.println("|id" + user.getId() + "\t");
			System.out.println("|pw" + user.getPw() + "\t");
			System.out.println("|phone" + user.getPhone() + "\t");
			System.out.println("|email" + user.getEmail() + "\t");
			System.out.println("|registrationDate" + user.getRegistrationDate() + "\t");
			System.out.println("|updateDate" + user.getUpdateDate() + "\t");
		}
		
		System.out.println("END ----------------");
	}

}
