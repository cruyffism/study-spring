package patient;
//예약 환자 정보를 담고 있다. reservationNum으로 예약 구분 
public class Patient {
		private String patientName; //환자 이름
		private String address; //주소
		private String phone; // 연락처
		private String email; // 이메일
		private String department; // 진료과
		private String registrationNum ; // 주민등록번호
		private String reservationNum; // 예약번호
		private String inputDate; // 최초입력일
		private char gender; //성별
		
		//생성자에서 필드를 초기화
		public Patient(String patientName, String address, String phone, String email, String department,
				String registrationNum, String reservationNum, String inputDate, char gender) {
			super();
			this.patientName = patientName;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.department = department;
			this.registrationNum = registrationNum;
			this.reservationNum = reservationNum;
			this.inputDate = inputDate;
			this.gender = gender;
		}
		
		//모든 필드에 대해 getter와 setter 메서드 
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getRegistrationNum() {
			return registrationNum;
		}
		public void setRegistrationNum(String registrationNum) {
			this.registrationNum = registrationNum;
		}
		public String getReservationNum() {
			return reservationNum;
		}
		public void setReservationNum(String reservationNum) {
			this.reservationNum = reservationNum;
		}
		public String getInputDate() {
			return inputDate;
		}
		public void setInputDate(String inputDate) {
			this.inputDate = inputDate;
		}
		public char getGender() {
			return gender;
		}
		public void setGender(char gender) {
			this.gender = gender;
		}
		
		
		
}
