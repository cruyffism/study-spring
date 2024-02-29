package member;

import java.sql.Date;
// 회원 정보를 담고 있다. userNum으로 회원을 구분
public class User {
		private String userNum;
		private String id;
		private String pw;
		private String phone;
		private String email;
		private Date registrationDate;
		private Date updateDate;
		
		//생성자에서 필드를 초기화
		public User(String id, String pw, String phone, String email, Date registrationDate, Date updateDate) {
			super();
			this.id = id;
			this.pw = pw;
			this.phone = phone;
			this.email = email;
			this.registrationDate = registrationDate;
			this.updateDate = updateDate;
		}
		
		//모든 필드에 대해 getter와 setter 메서드 
		public String getUserNum() {
			return userNum;
		}

		public void setUserNum(String userNum) {
			this.userNum = userNum;
		}

		public String getId() {
			return id;
		}
	
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
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
		public Date getRegistrationDate() {
			return registrationDate;
		}
		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}
		public Date getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
}
