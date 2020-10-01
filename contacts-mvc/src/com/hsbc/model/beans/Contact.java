package com.hsbc.model.beans;

public class Contact {
	
	private int userId;
	private int contactId;
	private String contactName;
	private long contactPhone;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public long getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(long contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	

}
