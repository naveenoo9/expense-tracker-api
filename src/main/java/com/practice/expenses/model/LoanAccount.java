package com.practice.expenses.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue(value = "LOAN")
@NoArgsConstructor @Getter @Setter @ToString
public class LoanAccount extends Account  {
  private long principleAmnt;
  private long emiAmnt;
  private int interest;
  private int dueDayofMonth;
  private int tenure;
  private int paidTenure;

  public LoanAccount(String acctNumber, String acctName, long dueAmount, boolean isActive, long principleAmnt,
      long emiAmnt, int interest, int dueDayofMonth, int tenure, int paidTenure) {
    super(acctNumber, acctName, dueAmount, isActive);
    this.principleAmnt = principleAmnt;
    this.emiAmnt = emiAmnt;
    this.interest = interest;
    this.dueDayofMonth = dueDayofMonth;
    this.tenure = tenure;
    this.paidTenure = paidTenure;
  }
  
  public LoanAccount(Account account) {
    super( account.getAcctName(), account.getAcctNumber() , account.getBalance(), account.isActive());
  }
}
