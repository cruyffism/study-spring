package ch02_pjt_01;

public class MyCalculator {

	public void calculate(int fNum, int sNum, ICalculator calculator) {
		int value = calculator.doOperation(fNum, sNum);
		System.out.println("result : " + value);
	}

	/*
	 * public void calAdd(int fNum, int sNum, CalAdd calAdd ) { ICalculator
	 * calculator = new CalAdd(); // calAdd 객체 생성 int value =
	 * calAdd.doOperation(fNum, sNum); //덧셈 실행 System.out.println("result : " +
	 * value); }
	 * 
	 * public void calSub(int fNum, int sNum, CalSub calSub ) { ICalculator
	 * calculator = new CalSub(); // CalSub 객체 생성 int value =
	 * calSub.doOperation(fNum, sNum); //뺄셈 실행 System.out.println("result : " +
	 * value); }
	 * 
	 * public void calMul(int fNum, int sNum, CalMul calMul ) { ICalculator
	 * calculator = new CalMul(); // CalMul 객체 생성 int value =
	 * calMul.doOperation(fNum, sNum); //곱셈 실행 System.out.println("result : " +
	 * value); }
	 * 
	 * public void calDiv(int fNum, int sNum, CalDiv calDiv ) { ICalculator
	 * calculator = new CalDiv(); // CalDiv 객체 생성 int value =
	 * calDiv.doOperation(fNum, sNum); //나눗셈 실행 System.out.println("result : " +
	 * value); }
	 */
}
