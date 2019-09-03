package org.soltani.web;

import lombok.Data;
import org.soltani.dao.AppUserRepository;
import org.soltani.entities.AppUser;
import org.soltani.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
    }
    @GetMapping("/appUsers")
    public List<AppUser> getUser() {
        return appUserRepository.findAll();
    }
}

@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
}
