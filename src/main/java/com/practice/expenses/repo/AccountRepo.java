package com.practice.expenses.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.expenses.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
  
}
