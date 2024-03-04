package ch05_pjt_01.contact.service;

import org.springframework.beans.factory.annotation.Autowired;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

public class ContactSearchService {
	//@Autowired를 필드,메소드,생성자에 다 쓸 수 있지만 보통 필드에 사용한다. 직관적임!!
	//@Autowired //필드에 @Autowired 할 시 기본 생성자가 없더라도 기본 생성자가 자동 실행 됨
	private ContactDao contactDao;
	
	/*
	 * public ContactSearchService() { System.out.println("default constructor"); }
	 */
	
	/*
	 * @Autowired public ContactSearchService(ContactDao contactDao) { //생성자
	 * System.out.println("contactDao: " + contactDao); this.contactDao =
	 * contactDao; }
	 */
	
	public ContactSet searchContact(String name) {
		if(verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is available");
		}
		
		return null;
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}
	
	@Autowired
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
