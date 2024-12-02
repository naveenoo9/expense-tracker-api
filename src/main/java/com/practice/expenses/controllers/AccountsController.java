package com.practice.expenses.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.expenses.model.Account;
import com.practice.expenses.service.AccountService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/accounts/v1")
public class AccountsController {

  private @Autowired AccountService accountService;

  @GetMapping("")
  public ResponseEntity<List<Account>> getListOfAccounts() {
    List<Account> accounts = accountService.getAllAccounts();
    return ResponseEntity.status(HttpStatus.OK.value()).body(accounts);
  }

  @PostMapping("")  
  public ResponseEntity<Account> addNewSavingsAccount(@RequestBody Map<String, String> reqMap,
      @RequestParam String acctType) {
    Account account = accountService.createNewAccount(reqMap, acctType);
    return ResponseEntity.status(HttpStatus.CREATED.value()).body(account);
  }
  
}
