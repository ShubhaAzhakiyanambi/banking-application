package com.bankapp.services;

import com.bankapp.models.Account;
import com.bankapp.models.Transaction;
import com.bankapp.repositories.AccountRepository;
import com.bankapp.repositories.TransactionRepository;
import com.bankapp.utils.CreateAccountInput;
import com.bankapp.utils.TransactionInput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	public Account getAccount(String accountNumber) {
		Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

		account.ifPresent(value -> value.setTransactions(transactionRepository.findBySourceAccountId(value.getId())));

		return account.orElse(null);
	}
	
	public Account getAccountByUsername(String username) {
		Optional<Account> account = accountRepository.findByUsername(username);

		return account.orElse(null);
	}

	public String createAccount(CreateAccountInput createAccountInput) {
		LOGGER.debug("Triggered AccountService.createAccountInput");

		String accNum = randomAccNum();
		Account account = new Account(randomAccId(), accNum, 0, createAccountInput.getBankName(),
				createAccountInput.getOwnerName(), createAccountInput.getUsername(), createAccountInput.getPassword() );

		accountRepository.save(account);
		LOGGER.debug("Account Created Successfully");
		return "Account number : " + accNum;

	}

	private long randomAccId() {
		Random random = new Random();
		return 10 + random.nextInt(90);
	}

	private String randomAccNum() {
		Random random = new Random();
		return String.valueOf(10000000 + random.nextInt(90000000));
	}

}
