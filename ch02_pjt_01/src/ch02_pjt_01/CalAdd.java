package ch02_pjt_01;

public class CalAdd implements ICalculator { //자식
	@Override
	public int  doOperation(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}
}
