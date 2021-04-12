package com.thevirtualx.mvcApp.Repo;

import com.thevirtualx.mvcApp.Entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
