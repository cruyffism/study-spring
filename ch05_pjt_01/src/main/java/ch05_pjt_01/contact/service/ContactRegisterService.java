package ch05_pjt_01.contact.service;

import org.springframework.beans.factory.annotation.Autowired;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactRegisterService {
	//@Autowired를 필드,메소드,생성자에 다 쓸 수 있지만 보통 필드에 사용한다. 직관적임!!
	//@Autowired  //필드에 @Autowired 할 시 기본 생성자가 없더라도 기본 생성자가 자동 실행 됨 + ContactDao가 자동으로 주입 됨
	private ContactDao contactDao;
	
	/*
	 * public ContactRegisterService() { System.out.println("default constructor");
	 * }
	 */
	
	
	/*
	 * @Autowired public ContactRegisterService(ContactDao contactDao) { //생성자
	 * System.out.println("contactDao: " + contactDao); this.contactDao =
	 * contactDao; }
	 */
	
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if(verify(name)) { // null이면
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered");
		}
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}
	
	@Autowired // 메소드에 @Autowired 사용하는 방식
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
