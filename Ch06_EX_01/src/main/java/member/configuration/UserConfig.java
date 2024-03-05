package member.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ems.utils.InitSampleData;
import member.DBConnectionInfo;
import member.dao.UserDao;
import member.service.EMSInformationService;
import member.service.PrintUserInformationService;
import member.service.UserAllSelectService;
import member.service.UserDeleteService;
import member.service.UserModifyService;
import member.service.UserRegisterService;
import member.service.UserSelectService;

@Configuration 
public class UserConfig {
	
	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		
		String[] userNum = {"hbs001", "hbs002", "hbs003", "hbs004", "hbs005"};
		initSampleData.setUserNum(userNum);
		
		String[] id = {"messi", "neymar", "kaka", "zidane", "reus"};
		initSampleData.setId(id);
		
		String[] pw = {"p0001", "p0002", "p0003", "p0004", "p0005"};
		initSampleData.setPw(pw);
	
		String[] phone = {"010-1234-4567", "010-1245-4567", "010-5858-6363", "010-7878-8585", "010-1245-4484"};
		initSampleData.setPhone(phone);
		
		String[] email = {"messi@daum.net", "ney@daum.net", "kaka@daum.net", "zidane@daum.net", "reus@daum.net"};
		initSampleData.setEmail(email);
		
		String[] registrationDate = {"2024-02-02", "2024-02-02", "2024-02-02", "2024-02-02", "2024-02-02"};
		initSampleData.setRegistrationDate(registrationDate);
		
		String[] updateDate = {"2024-03-02", "2024-03-02", "2024-03-02", "2024-03-02", "2024-03-02"};
		initSampleData.setUpdateDate(updateDate);
		
		return initSampleData;
	}
	
	@Bean // 빈객체 생성
	public UserDao userDao() {
		return new UserDao();
	}
	
	//생성자를 이용한 의존객체 주입
	@Bean // ..service() 이용 주입
	public UserRegisterService userRegisterService() {
		return new UserRegisterService(userDao());
	}
	
	@Bean 
	public UserModifyService userModifyService() {
		return new UserModifyService(userDao());
	}
	
	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService(userDao());
	}
	
	@Bean
	public UserSelectService userSelectService() {
		return new UserSelectService(userDao());
	}
	
	@Bean 
	public UserAllSelectService userAllSelectService() {
		return new UserAllSelectService(userDao());
	}
	
	@Bean
	public PrintUserInformationService printUserInformationService() {
		return new PrintUserInformationService(userAllSelectService());
	}
	
	@Bean //setter 이용 주입
	public DBConnectionInfo dev_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("000.000.000.000");
		dbConnectionInfo.setUserId("admin");
		dbConnectionInfo.setUserPw("0000");
		
		return dbConnectionInfo;
	}
	
	@Bean
	public DBConnectionInfo real_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("111,111,111,111");
		dbConnectionInfo.setUserId("master");
		dbConnectionInfo.setUserPw("1111");
		
		return dbConnectionInfo;
	}
	
	@Bean //setter 주입 시 List, map
	public EMSInformationService eMSInformationService() {
		EMSInformationService emsInformationService =
				new EMSInformationService();
		emsInformationService.setInfo("Education Management System program was developed in 2022.");
		emsInformationService.setCopyRight("COPYRIGHT(C) 2022 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		emsInformationService.setVer("The version is 1.0");
		emsInformationService.setsYear(2022);
		emsInformationService.setsMonth(3);
		emsInformationService.setsDay(1);
		emsInformationService.seteYear(2022);
		emsInformationService.seteMonth(4);
		emsInformationService.seteDay(30);
		
		List<String> developers = new ArrayList<String>();
		developers.add("Cheney.");
		developers.add("Eloy.");
		developers.add("Jasper.");
		developers.add("Dillon.");
		developers.add("Kian.");
		emsInformationService.setDevelopers(developers);
		
		Map<String, String> administrators = new HashMap<String, String>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "Jasper@springPjt.org");
		emsInformationService.setAdministrators(administrators);
		
		Map<String, DBConnectionInfo> dbInfos = new HashMap<String, DBConnectionInfo>();
		dbInfos.put("dev", dev_DBConnectionInfoDev());
		dbInfos.put("real", real_DBConnectionInfoDev());
		emsInformationService.setDbInfos(dbInfos);
		
		return emsInformationService;
	}
		
}
