package com.bankapp.utils;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankapp.repositories.AccountRepository;

public class InputValidator {
	
	//Account number should be 8 digits
    private static final Pattern accountNumberPattern = Pattern.compile("^[0-9]{8}$");

    @Autowired
    private static AccountRepository accountRepository;
    
    public static boolean isSearchCriteriaValid(AccountInput accountInput) {
        return accountNumberPattern.matcher(accountInput.getAccountNumber()).find();
    }

        
    public static boolean isSearchTransactionValid(TransactionInput transactionInput) {
        
        if (!isSearchCriteriaValid(transactionInput.getSourceAccount()))
            return false;

        if (!isSearchCriteriaValid(transactionInput.getTargetAccount()))
            return false;

		//returns false if source and target accounts are same
        if (transactionInput.getSourceAccount().equals(transactionInput.getTargetAccount()))
            return false;

        return true;
    }
}
