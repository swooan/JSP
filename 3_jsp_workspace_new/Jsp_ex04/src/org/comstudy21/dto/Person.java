package org.comstudy21.dto;

public class Person {
	private String userName = "홍길동";
	private String userAddr = "서울시 광진구 광장동";
	private int age = 30;
	
	public Person() {
		this.userName = "";
		this.userAddr = "";
		this.age = 0;
	}

	public Person(String userName, String userAddr, int age) {
		this.userName = userName;
		this.userAddr = userAddr;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", userAddr=" + userAddr + ", age=" + age + "]";
	}
	
	
	
}
