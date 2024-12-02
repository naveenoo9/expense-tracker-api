package com.practice.expenses.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity @DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account {
  private @Column(name = "ifsc_code")  String ifscCode;
  private String address;

  public SavingsAccount(long acctId, String acctNumber, String acctName, long balance, boolean isActive, String ifscCode, String address) {
    super(acctNumber, acctName, balance, isActive);
    this.ifscCode = ifscCode;
    this.address = address;
  }

  public SavingsAccount() {
  }

  public SavingsAccount(Account account) {
    super( account.getAcctName(), account.getAcctNumber() , account.getBalance(), account.isActive());
  }
  
  public String toString() {
    return "SavingsAccount: [ acctId: " + super.getAcctId() + "acctName: " + super.getAcctName() + "balance: " + super.getBalance() +  "isActive: " + super.isActive()  + "ifsc: " + this.ifscCode + "address: " + this.address + "]";
  }
}
