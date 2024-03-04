package ch05_pjt_03.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_03.contact.ContactSet;

public class ContactDao {
	
	private	Map<String, ContactSet> contactDB = new HashMap<String, ContactSet>();//HashMapdmf 이용해서 데이터 관리
	
	public void insert(ContactSet contactSet) {
		contactDB.put(contactSet.getName(), contactSet);
	}
	
	public ContactSet select(String name) {
		return contactDB.get(name);
	}
	
	public Map<String, ContactSet> getContactDB() {
		return contactDB;
	}
}
