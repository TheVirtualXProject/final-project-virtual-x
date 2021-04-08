package com.thevirtualx.mvcApp.Service;

import com.thevirtualx.mvcApp.Entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
