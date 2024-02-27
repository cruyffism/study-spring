package ch03_pjt_03;

import org.springframework.context.support.GenericXmlApplicationContext;

//IOC 방식
public class MainClass { 

	public static void main(String[] args) {
		
		/* new CalAssembler(); */
		
		GenericXmlApplicationContext ctx = 
		 new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		CalAssembler calAssembler = 
		 ctx.getBean("calAssembler", CalAssembler.class);
		calAssembler.assemble();
		
	    ctx.close();
	}

}
