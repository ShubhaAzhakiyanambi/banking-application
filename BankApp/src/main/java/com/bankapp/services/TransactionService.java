package com.bankapp.services;

import com.bankapp.controller.AccountRestController;
import com.bankapp.models.Account;
import com.bankapp.models.Transaction;
import com.bankapp.repositories.AccountRepository;
import com.bankapp.repositories.TransactionRepository;
import com.bankapp.utils.TransactionInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public boolean makeTransfer(TransactionInput transactionInput) {
        LOGGER.debug("Triggered TransactionService.transactionInput");
        String sourceAccountNumber = transactionInput.getSourceAccount().getAccountNumber();
        Optional<Account> sourceAccount = accountRepository
                .findByAccountNumber(sourceAccountNumber);

        String targetAccountNumber = transactionInput.getTargetAccount().getAccountNumber();
        Optional<Account> targetAccount = accountRepository
                .findByAccountNumber(targetAccountNumber);

        if (sourceAccount.isPresent() && targetAccount.isPresent()) {
            if (isAmountAvailable(transactionInput.getAmount(), sourceAccount.get().getCurrentBalance())) {
                Transaction transaction = new Transaction();

                transaction.setAmount(transactionInput.getAmount());
                transaction.setSourceAccountId(sourceAccount.get().getId());
                transaction.setTargetAccountId(targetAccount.get().getId());
                transaction.setTargetOwnerName(targetAccount.get().getOwnerName());
                transaction.setReason(transactionInput.getReason());
                updateTargetAccountBalance(targetAccount.get(), transactionInput.getAmount());
                updateSourceAccountBalance(sourceAccount.get(), transactionInput.getAmount());
                transactionRepository.save(transaction);
				LOGGER.debug("Amount transferred successfully");
                return true;
            }
        }
        return false;
    }

    private void updateTargetAccountBalance(Account account, double amount) {
		LOGGER.debug("Entering updateAccountBalance method");
        account.setCurrentBalance((account.getCurrentBalance() + amount));
        accountRepository.save(account);
		LOGGER.debug("Savings account balance updated");
    }
    
    private void updateSourceAccountBalance(Account account, double amount) {
		LOGGER.debug("Entering updateAccountBalance method");
        account.setCurrentBalance((account.getCurrentBalance() - amount));
        accountRepository.save(account);
		LOGGER.debug("Savings account balance updated");
    }

    // TODO support overdrafts or credit account
    private boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }
}