package com.thevirtualx.mvcApp.Security;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Repo.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private AccountRepository accountRepo;

    public SecurityUserDetailsService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepo.findByUsername(username);
        if (accountOptional.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }
        return accountOptional.map(SecurityUserDetails::new).get();

    }
}
