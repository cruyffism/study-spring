package community;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.support.GenericXmlApplicationContext;

import ems.utils.InitSampleData;
import member.User;
import member.service.PrintUserInformationService;
import member.service.UserRegisterService;
import member.service.UserSelectService;

public class MainClass {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		// 샘플 데이터
		InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
		String[] userNum = initSampleData.getUserNum();
		String[] id = initSampleData.getId();
		String[] pw = initSampleData.getPw();
		String[] phone = initSampleData.getPhone();
		String[] email = initSampleData.getEmail();
		String[] registrationDate = initSampleData.getRegistrationDate();
		String[] updateDate = initSampleData.getUpdateDate();

		// 데이터베이스에 샘플 데이터 등록
		UserRegisterService registerService = ctx.getBean("userRegisterService", UserRegisterService.class);
		for (int i = 0; i < userNum.length; i++) {
			registerService.register(
					new User(userNum[i], id[i], pw[i], phone[i], email[i], registrationDate[i], updateDate[i]));
		}

		// 유저 리스트
		PrintUserInformationService printUserInformationService = ctx.getBean("printUserInformationService",
				PrintUserInformationService.class);
		printUserInformationService.printUserInfo(); // 유저 리스트

		// 유저 등록

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		registerService = ctx.getBean("userRegisterService", UserRegisterService.class);

		registerService.register(new User("hbs006", "xavi", "p0006", "010-3356-3369", "xavi@daum.net",
				"2024-02-07", "2024-03-07"));

		// 유저 출력
		UserSelectService selectService = ctx.getBean("userSelectService", UserSelectService.class);
		User selecteduser = selectService.select("hbs006");

		System.out.println("USER START ------------------");
		System.out.println("userNum" + selecteduser.getUserNum() + "\t");
		System.out.println("|id" + selecteduser.getId() + "\t");
		System.out.println("|pw" + selecteduser.getPw() + "\t");
		System.out.println("|phone" + selecteduser.getPhone() + "\t");
		System.out.println("|email" + selecteduser.getEmail() + "\t");

		System.out.println("|registrationDate" + selecteduser.getRegistrationDate() + "\t");
		System.out.println("|updateDate" + selecteduser.getUpdateDate() + "\t");

	}

}
