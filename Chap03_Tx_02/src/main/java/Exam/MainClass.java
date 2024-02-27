package Exam;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Select language! 1.korea  2.english");
		Scanner scanner = new Scanner(System.in);
		
		int selectedNumber = scanner.nextInt();
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		PrintHello printHello = ctx.getBean("printHello", PrintHello.class);
		
		switch (selectedNumber) {
		case 1:
			printHello.hello_ko();
			break;
			
		case 2:
			printHello.hello_en();
			break;

		}
		
		ctx.close();
		scanner.close();

	}

}
