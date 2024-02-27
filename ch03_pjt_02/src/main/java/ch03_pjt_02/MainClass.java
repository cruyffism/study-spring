package ch03_pjt_02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	// 메인클래스가 TransportationWalk클래스에 의존한다.
	public static void main(String[] args) {
		
		/*
		 * TransportationWalk transportationWalk = new TransportationWalk();
		 * //transportationWalk 객체 생성 transportationWalk.move(); //move 메소드 호출
		 */
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk transportationWalk =
				ctx.getBean("tWalk", TransportationWalk.class); // (beanid, 인스턴스 발생 클래스)
		transportationWalk.move();
		
		ctx.close();
 		
	}

}
