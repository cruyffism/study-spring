package member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import member.User;

public class PrintUserInformationService { //전체 회원 정보 출력
	@Autowired  //필드에 @Autowired 할 시 생성자 만들필요없음!
	UserAllSelectService allSelectService;
	
	/*
	 * public PrintUserInformationService(UserAllSelectService allSelectService) {
	 * this.allSelectService = allSelectService; }
	 */
	
	public void printUserInfo() {
		Map<String, User> allUser = allSelectService.allSelect(); //allSelectService 객체의 allSelect() 메서드를 호출하여 모든 회원 정보를 가져옵니다. 이 정보는 Map<String, User> 형태로 반환됩니다.
		Set<String> Keys = allUser.keySet(); // set에는 순서가 없이  key, value가 존재!
		Iterator<String> iterator = Keys.iterator(); // 컨테이너, 특히 리스트를 순화할 수 있게 해주는 객체
		System.out.println("USER LIST START ----------------");
		while (iterator.hasNext()) {
			String key = iterator.next();
			User user = allUser.get(key);
			System.out.print("userNum: " + user.getUserNum() + "\t");
			System.out.print("|id: " + user.getId() + "\t");
			System.out.print("|pw: " + user.getPw() + "\t");
			System.out.print("|phone: " + user.getPhone() + "\t");
			System.out.print("|email: " + user.getEmail() + "\t");
			System.out.print("|registrationDate: " + user.getRegistrationDate() + "\t");
			System.out.println("|updateDate: " + user.getUpdateDate() + "\t");
		}
		
		System.out.println("END ----------------");
	}

}
