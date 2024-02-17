package com.example.ewalletuserservice;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public class UserCreateRequest {

    @NotBlank
    private String name;

    private String contact;

    @Email
    @NotBlank
    private String email;

    public User to(){
    	
    	User user=new User();
    	user.setEmail(this.email);
    	user.setContact(this.contact);
    	user.setName(this.name);
       return user;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserCreateRequest(@NotBlank String name, String contact, @Email @NotBlank String email) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
	}
    
	public UserCreateRequest()
	{
		
	}
}