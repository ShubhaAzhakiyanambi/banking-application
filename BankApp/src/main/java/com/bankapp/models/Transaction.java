package com.bankapp.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions", schema = "bank_app")

@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_sequence", schema = "bank_app", initialValue = 5)
public class Transaction {

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    private long id;

    private long sourceAccountId;

    private long targetAccountId;

    private String targetOwnerName;

    private double amount;

    private String reason;

    public Transaction() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getSourceAccountId() {
        return sourceAccountId;
    }
    public void setSourceAccountId(long sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }
    public long getTargetAccountId() {
        return targetAccountId;
    }
    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }
    public String getTargetOwnerName() {
        return targetOwnerName;
    }
    public void setTargetOwnerName(String targetOwnerName) {
        this.targetOwnerName = targetOwnerName;
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
        return "Transaction{" +
                "sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                ", targetOwnerName='" + targetOwnerName + '\'' +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }

}
