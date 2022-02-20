package com.epharmacy.epharmacy.service;

import com.epharmacy.epharmacy.model.AppRole;
import com.epharmacy.epharmacy.model.AppUser;


public interface AccountService {
    public AppUser saveUser(String username, String password, String confirmedPassword);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}
