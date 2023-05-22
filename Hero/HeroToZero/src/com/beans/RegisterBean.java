package com.beans;

import java.io.Serializable;



public class RegisterBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int ide;
	private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String email;
    
    public int getIde() {
		return ide;
	}
	public void setIde(int ide) {
		this.ide = ide;
	}
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}