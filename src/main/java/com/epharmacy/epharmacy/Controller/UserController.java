package com.epharmacy.epharmacy.Controller;
import com.epharmacy.epharmacy.Repository.AppUserRepository;
import com.epharmacy.epharmacy.model.AppRole;
import com.epharmacy.epharmacy.model.AppUser;
import com.epharmacy.epharmacy.service.AccountService;
import lombok.Data;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;



@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private AccountService accountService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private AppUserRepository appUserRepository;

    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm) {
        System.out.println(userForm.toString());
        return accountService.saveUser(
                userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword(), "USER");
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginForm loginForm) {
        // throws Exception if authentication failed

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generate(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            AppUser user = appUserRepository.findByUsername(userDetails.getUsername());
            System.out.println(user);
            System.out.println(jwt);
            return ResponseEntity.ok(new JwtResponse(jwt, user.getUsername(), user.getRoles()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
}

@Data
class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String name;
    private String role;

    public JwtResponse(String token, String name, Collection<AppRole> role) {
        this.name = name;
        this.token = token;
        this.role = String.valueOf(role);
    }
}

@Data
class LoginForm {

    private String username;
    private String password;
}

