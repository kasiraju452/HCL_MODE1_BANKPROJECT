package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer uId;
//	
//	private String username;
//	
//	private String password;
//	
//	@Column(name="role")
//	@CollectionTable(name="roles")
//	@ElementCollection(fetch=FetchType.EAGER)
//	private List<String> roles = new ArrayList<>();
//	
//	private String address;
//	
//	private String phone;
//	
//	private String email;
//	
//	@Enumerated(EnumType.STRING)
//	private UserType userType;
//
//	public Integer getuId() {
//		return uId;
//	}
//
//	public void setuId(Integer uId) {
//		this.uId = uId;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<String> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<String> roles) {
//		this.roles = roles;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public User(String username, String password, List<String> roles, String address, String phone, String email) {
//		this.username = username;
//		this.password = password;
//		this.roles = roles;
//		this.address = address;
//		this.phone = phone;
//		this.email = email;
//	}
//
//	public User(Integer uId, String username, String password, List<String> roles, String address, String phone,
//			String email) {
//		this.uId = uId;
//		this.username = username;
//		this.password = password;
//		this.roles = roles;
//		this.address = address;
//		this.phone = phone;
//		this.email = email;
//	}
//
//	public User() {
//	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	private String username;
	private String password;
	
	@Column(name = "role")
	@CollectionTable(name = "roles")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles = new ArrayList<>();
	
	private String address;
	private String phone;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	public User() {}

	public User(int uid, String username, String password, List<String> roles, String address, String phone,
			String email) {
		
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public User(String username, String password, UserType userType, String address, String phone, String email) {
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public User(String username, String password, List<String> roles, String address, String phone, String email) {
	
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
