package vttp2022.day2.workshop;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
//package to generate uuid

public class BankAccount {
    //Bank Account
    private String name ="";

    //this is a generated account id from the java util UUID class
    private String acctId = UUID.randomUUID().toString().substring(0,0);

    //hlods the bank account balance
    private float balance = 0f;

    //list of transaction history in the event of anything done on the bank account object
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;

    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //Constructor with bank account name
    BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }

    //2nd constructor 
    public BankAccount(String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;
    }

    //Getter and setter for the rest of the properties
    public String getName() {
        return name;
    }

    public String getAcctId() {
        return acctId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public float withdraw(String withdrawAmt) {
        Float withdrawAmtF = null;
        try {
            withdrawAmtF = Float.parseFloat(withdrawAmt);

            if (withdrawAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Amount cannot be negative or 0");
            }

            if (this.isClosed()) {
                throw new IllegalArgumentException("Account is closed");
            }

            if(withdrawAmtF.floatValue() > this.balance) {
                throw new IllegalArgumentException("Not enough money");
            }

            //update the withdrawal amount
            this.balance = this.balance - withdrawAmtF.floatValue();

            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());

            //save the event log into the txn LinkedList
            transaction.add(txnStrbld.toString());

        }
        catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        return withdrawAmtF.floatValue();
    }

    public void deposit (String depositAmt) {
        try {
            Float depositAmtF = Float.parseFloat(depositAmt);

            if (depositAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Amount cannot be negative or 0");
            }

            if (this.isClosed()) {
                throw new IllegalArgumentException("Account is closed");
            }

            //update the deposit amount
            this.balance = this.balance + depositAmtF.floatValue();

            //Construct the transaction history event log
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());

            //save the event log into the txn LinkedList
            transaction.add(txnStrbld.toString());

        }
        catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }

}
