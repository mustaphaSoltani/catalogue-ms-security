package org.soltani.service;

import org.soltani.entities.AppRole;
import org.soltani.entities.AppUser;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface AccountService {
    public AppUser saveUser(String username, String password, String confirmPassword);
    public AppRole saveRoles(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String role);
}
