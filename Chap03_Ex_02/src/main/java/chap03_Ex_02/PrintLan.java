package chap03_Ex_02;

import java.util.Scanner;

public class PrintLan {
	
	public void select() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select language! 1.korea 2.english");
		int i = sc.nextInt();
		
		if (i == 1) {
			System.out.println("안녕하세요.");
		} else if (i == 2) {
			System.out.println("Hello");
		} else {
			System.out.println("번호는 1번 혹은 2번만 가능합니다.");
		}
	}
}
