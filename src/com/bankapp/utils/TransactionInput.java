package com.bankapp.utils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class TransactionInput {

    private AccountInput sourceAccount;

    private AccountInput targetAccount;

    @Positive(message = "Transfer amount must be positive")
    // Prevent fraudulent transfers attempting to abuse currency conversion errors
    @Min(value = 1, message = "Amount must be larger than 1")
    private double amount;

    private String reason;

    public TransactionInput() {}

    public AccountInput getSourceAccount() {
        return sourceAccount;
    }
    public void setSourceAccount(AccountInput sourceAccount) {
        this.sourceAccount = sourceAccount;
    }
    public AccountInput getTargetAccount() {
        return targetAccount;
    }
    public void setTargetAccount(AccountInput targetAccount) {
        this.targetAccount = targetAccount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "TransactionInput{" +
                "sourceAccount=" + sourceAccount +
                ", targetAccount=" + targetAccount +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
