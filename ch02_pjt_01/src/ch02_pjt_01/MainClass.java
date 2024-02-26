package ch02_pjt_01;
//DI 방식
public class MainClass {

	public static void main(String[] args) {
		MyCalculator calculator = new MyCalculator();
		
		calculator.calculate(10, 5, new CalAdd()); //객체 주입
		calculator.calculate(10, 5, new CalSub()); //객체 주입
		calculator.calculate(10, 5, new CalMul()); //객체 주입
		calculator.calculate(10, 5, new CalDiv()); //객체 주입
		/*
		 * calculator.calAdd(10,5, new CalAdd()); calculator.calSub(10,5, new CalSub());
		 * calculator.calMul(10,5, new CalMul()); calculator.calDiv(10,5, new CalDiv());
		 */
	    
	}

}
