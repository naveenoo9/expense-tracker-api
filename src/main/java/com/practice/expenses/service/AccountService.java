package com.practice.expenses.service;

import java.util.List;
import java.util.Map;

import com.practice.expenses.model.Account;

public interface AccountService {
  Account createNewAccount(Map<String, String> request, String acctType);
  List<Account> getAllAccounts();
}
