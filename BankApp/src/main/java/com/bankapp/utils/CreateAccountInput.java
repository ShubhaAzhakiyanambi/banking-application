package com.bankapp.utils;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class CreateAccountInput {

	@NotBlank(message = "Username is mandatory")
	private String username;
	@NotBlank(message = "Password is mandatory")
	private String password;
	@NotBlank(message = "BankName is mandatory")
	private String bankName;
	@NotBlank(message = "Owner name is mandatory")
	private String ownerName;

	public CreateAccountInput() {
	}

	public String getUsername() {
		return username;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "CreateAccountInput [username=" + username + ", password=" + password + ", bankName=" + bankName
				+ ", ownerName=" + ownerName + "]";
	}

}
