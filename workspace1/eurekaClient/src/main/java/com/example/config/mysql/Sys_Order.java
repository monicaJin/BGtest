package com.example.config.mysql;

public class Sys_Order {
	
	private String id;
	private String client_document_no;

	public Sys_Order() {
		// TODO Auto-generated constructor stub
	}

	public String getClient_document_no() {
		return client_document_no;
	}

	public void setClient_document_no(String client_document_no) {
		this.client_document_no = client_document_no;
	}
	
	public String toString() {
		return client_document_no;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
