package com.bankapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "account", schema = "bank_app")
public class Account {

    @Id
    private long id;

    private String accountNumber;

    private double currentBalance;

    private String bankName;

    private String ownerName;
    
    private String username;

    private String password;

    private transient List<Transaction> transactions;

    protected Account() {}
    public Account(long id, String accountNumber, double currentBalance, String bankName, String ownerName, String username, String password) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.username = username;
        this.password = password;
    }
    public Account(long id, String accountNumber, double currentBalance, String bankName, String ownerName, String username, String password, List<Transaction> transactions) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.username = username;
        this.password = password;
        this.transactions = transactions;
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
	public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", currentBalance=" + currentBalance
				+ ", bankName=" + bankName + ", ownerName=" + ownerName + ", username=" + username + ", password="
				+ password + "]";
	}

}
