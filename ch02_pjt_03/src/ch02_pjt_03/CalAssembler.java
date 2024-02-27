package ch02_pjt_03;
//IOC 컨테이너 >> 빈을 생성하고 필요한 곳에 주입(DI)하는 특별한 공간
public class CalAssembler { 
	MyCalculator calculator;
	CalAdd calAdd;
	CalSub calSub;
	CalMul calMul;
	CalDiv calDiv;
	
	public CalAssembler() {
		calculator = new MyCalculator(); //객체 생성
		calAdd = new CalAdd();
		calSub = new CalSub();
		calMul = new CalMul();
		calDiv = new CalDiv();
		
		assemble ();

	}
	
	public void assemble() {
		calculator.calculate(10, 5, calAdd);
		calculator.calculate(10, 5, calSub);
		calculator.calculate(10, 5, calMul);
		calculator.calculate(10, 5, calDiv);
	}
}
