package com.practice.expenses.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "accounts")
@NoArgsConstructor @Getter @Setter @ToString
public abstract class Account {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private @Column(name = "account_id") long acctId;
  private @Column(name = "account_name") String acctName;
  private @Column(name = "account_numer") String acctNumber;
  private @Column(name = "account_balance") long balance;
  private @Column(name = "account_status") boolean isActive;
  // private @Enumerated(EnumType.STRING) @Column(name = "account_type") AccountType acctType;
  public Account(String acctName, String acctNumber, long balance, boolean isActive) {
    this.acctNumber = acctNumber;
    this.acctName = acctName;
    this.balance = balance;
    this.isActive = isActive;
  }
}
