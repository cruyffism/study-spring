package ch02_pjt_01;

public class MainClass {

	public static void main(String[] args) {
		MyCalculator calculator = new MyCalculator();
		
		calculator.calculate(10, 5, new CalAdd());
		calculator.calculate(10, 5, new CalSub());
		calculator.calculate(10, 5, new CalMul());
		calculator.calculate(10, 5, new CalDiv());
		/*
		 * calculator.calAdd(10,5, new CalAdd()); calculator.calSub(10,5, new CalSub());
		 * calculator.calMul(10,5, new CalMul()); calculator.calDiv(10,5, new CalDiv());
		 */
	    
	}

}