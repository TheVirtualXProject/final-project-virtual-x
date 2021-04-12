package com.thevirtualx.mvcApp.Service;

import com.thevirtualx.mvcApp.Entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
