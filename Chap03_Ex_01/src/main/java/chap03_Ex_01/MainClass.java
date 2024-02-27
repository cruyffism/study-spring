package chap03_Ex_01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Hello hello = ctx.getBean("alsrl", Hello.class);
		hello.greet();
		
		ctx.close();
	}

}
