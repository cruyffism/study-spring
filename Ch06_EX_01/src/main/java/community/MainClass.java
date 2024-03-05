package community;


import org.springframework.context.support.GenericXmlApplicationContext;

import ems.utils.InitSampleData;
import member.User;
import member.service.EMSInformationService;
import member.service.PrintUserInformationService;
import member.service.UserDeleteService;
import member.service.UserModifyService;
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
		registerService = ctx.getBean("userRegisterService", UserRegisterService.class);
		registerService.register(new User("hbs006", "xavi", "p0006", "010-3356-3369", "xavi@daum.net",
				"2024-02-07", "2024-03-07"));

		// 유저 출력
		UserSelectService selectService = ctx.getBean("userSelectService", UserSelectService.class);
		User selecteduser = selectService.select("hbs006");

		System.out.println("USER START ------------------");
		System.out.print("userNum: " + selecteduser.getUserNum() + "\t");
		System.out.print("|id: " + selecteduser.getId() + "\t");
		System.out.print("|pw: " + selecteduser.getPw() + "\t");
		System.out.print("|phone: " + selecteduser.getPhone() + "\t");
		System.out.print("|email: " + selecteduser.getEmail() + "\t");
		System.out.print("|registrationDate: " + selecteduser.getRegistrationDate() + "\t");
		System.out.println("|updateDate: " + selecteduser.getUpdateDate() + "\t");
		
		//유저 수정
		UserModifyService modifyService = ctx.getBean("userModifyService", UserModifyService.class);
		modifyService.modify(new User("hbs006", "nasri", "p0006", "010-7778-7778", "nasri@daum.net","2024-02-07", "2024-03-07"));
		
		printUserInformationService.printUserInfo(); // 유저 리스트 
		
		//유저 삭제
		UserDeleteService deleteService = ctx.getBean("userDeleteService", UserDeleteService.class);
		deleteService.delete("hbs005");
		
		printUserInformationService.printUserInfo(); // 유저 리스트
		
		//시스템 정보
		EMSInformationService emsInformationService = ctx.getBean("eMSInformationService", EMSInformationService.class);
		emsInformationService.printEMSInformation();

		ctx.close(); 
		
	}

}
