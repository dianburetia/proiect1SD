package com.example.demo.controllers;

import com.example.demo.RoleA;
import com.example.demo.model.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins="*")
public class AccountController {
    private final AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @CrossOrigin(origins="*")
    @GetMapping
    public List<Account> getClients() {
        return accountRepository.findAll();
    }
    @CrossOrigin(origins="*")
    @GetMapping("/{name}")
    public Account getClientByName(@PathVariable String name) {
        List<Account> accountList=accountRepository.findAll();
        for(Account account:accountList){
            if(account.getName().equals(name))return account;
        }
        return null;
    }
    @CrossOrigin(origins="*")
    @GetMapping("/accounts")
    public long[] getClientsIds() {
        List<Account> accounts= accountRepository.findAll();
        long[] ids=new long[accounts.size()];
        int c=0;
        for(Account account:accounts){
            ids[c++]=account.getId();
        }
        return ids;
    }
    @CrossOrigin(origins="*")
    @PostMapping
    public void  createClient(@RequestBody Account account)  {
        //System.out.println(account.getDevicesIds());
         accountRepository.save(account);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account currentAccount = accountRepository.findById(id).orElseThrow(RuntimeException::new);
        currentAccount.setId(id);
        currentAccount.setName(account.getName());
        currentAccount.setRole(account.getRole());
        currentAccount.setPassword(account.getPassword());
        currentAccount.setDevicesIds(account.getDevicesIds());
        accountRepository.save(currentAccount);
        System.out.println(account.getDevicesIds());
        return ResponseEntity.ok(currentAccount);
    }
    @CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.DELETE}, allowedHeaders = {"*"})
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
