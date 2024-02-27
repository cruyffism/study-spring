package chap03_Ex_02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		PrintLan printLan = ctx.getBean("PrintLan", PrintLan.class);
		printLan.select();
		
		ctx.close();
	}

}
