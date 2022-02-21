package com.epharmacy.epharmacy.Controller;
import com.epharmacy.epharmacy.model.AppUser;
import com.epharmacy.epharmacy.service.AccountService;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public AppUser register(@RequestBody  UserForm userForm){
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),"USER");
    }
}
@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
}