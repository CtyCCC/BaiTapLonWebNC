package com.ccc.webBH.login.entity;

public class MailBox {
	private String subject;
	private String message;
	private String recipientEmail;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	@Override
	public String toString() {
		return "MailBox [subject=" + subject + ", message=" + message + ", recipientEmail=" + recipientEmail + "]";
	}
	public MailBox(String subject, String message, String recipientEmail) {
		super();
		this.subject = subject;
		this.message = message;
		this.recipientEmail = recipientEmail;
	}
	public MailBox() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
