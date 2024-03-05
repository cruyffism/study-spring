package member;
//데이터베이스 연결에 필요한 정보를 갖고 있다.
public class DBConnectionInfo {
	private String url;
	private String userId;
	private String userPw;
	
	//모든 필드에 대해 getter와 setter 메서드
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
}
