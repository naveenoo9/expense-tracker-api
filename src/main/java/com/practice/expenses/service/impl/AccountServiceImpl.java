package com.practice.expenses.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.expenses.model.Account;
import com.practice.expenses.model.AccountType;
import com.practice.expenses.model.LoanAccount;
import com.practice.expenses.model.SavingsAccount;
import com.practice.expenses.repo.AccountRepo;
import com.practice.expenses.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

  private @Autowired AccountRepo accountRepo;

  @Override
  public Account createNewAccount(Map<String, String> request, String acctType) {
    Account svdAcct = null, newAccount = null;
    try {
      switch (AccountType.valueOf(acctType)) {
        case SAVINGS:
          newAccount = mapToSavings(request);
          svdAcct = accountRepo.save(newAccount);
          break;
        case LOAN:
          newAccount = mapToLoans(request);
          svdAcct = accountRepo.save(newAccount);
          break;
        default:
          break;
      }
    } catch (Exception e) {
      System.out.println(e);
    }
      return svdAcct;
  }
  
  public static Account mapToSavings(Map<String, String> request) {
    SavingsAccount svngsAccount = new SavingsAccount(mapToAccount(request));
    if (request.containsKey("ifscCode"))
      svngsAccount.setIfscCode(request.get("ifscCode"));
    if (request.containsKey("address"))
      svngsAccount.setAddress(request.get("address"));
    return svngsAccount;
  }
  
  public static Account mapToLoans(Map<String, String> request) {
    LoanAccount account = new LoanAccount(mapToAccount(request));
    if (request.containsKey("principleAmnt")) {
      long principleAmnt = Long.parseLong(request.get("principleAmnt"));
      account.setPrincipleAmnt(principleAmnt);
    }
    if (request.containsKey("emiAmnt")) {
      long emiAmnt = Long.parseLong(request.get("emiAmnt"));
      account.setPrincipleAmnt(emiAmnt);
    }
    if (request.containsKey("interest")) {
      int interest = Integer.parseInt(request.get("interest"));
      account.setInterest(interest);
    }
    if (request.containsKey("dueDayofMonth")) {
      int dueDayofMonth = Integer.parseInt(request.get("dueDayofMonth"));
      account.setDueDayofMonth(dueDayofMonth);
    }
    if (request.containsKey("tenure")) {
      int tenure = Integer.parseInt(request.get("tenure"));
      account.setTenure(tenure);
    }
    if (request.containsKey("paidTenure")) {
      int paidTenure = Integer.parseInt(request.get("paidTenure"));
      account.setPaidTenure(paidTenure);
    }
    return account;
  }

  public static Account mapToAccount(Map<String, String> request) {
    Account account = new SavingsAccount();
    if (request.containsKey("acctNumber"))
      account.setAcctNumber(request.get("acctNumber"));
    if (request.containsKey("acctName"))
      account.setAcctName(request.get("acctName"));
    if (request.containsKey("balance")) {
      long balance = Long.parseLong(request.get("balance"));
      account.setBalance(balance);
    }
    if (request.containsKey("isActive")) {
      boolean isActive = Boolean.parseBoolean(request.get("isActive"));
      account.setActive(isActive);
    }
    return account;
  }

  @Override
  public List<Account> getAllAccounts() {
    return accountRepo.findAll();
  }
}
