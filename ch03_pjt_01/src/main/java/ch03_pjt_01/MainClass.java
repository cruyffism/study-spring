package ch03_pjt_01;

public class MainClass {
	// 메인클래스가 TransportationWalk클래스에 의존한다.
	public static void main(String[] args) {
		TransportationWalk transportationWalk = new TransportationWalk(); //TransportationWalk 객체 생성
		transportationWalk.move(); //move 메소드 호출
	}

}
