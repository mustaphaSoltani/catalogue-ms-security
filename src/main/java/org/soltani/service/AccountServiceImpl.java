package org.soltani.service;

import org.soltani.dao.AppRolesRepository;
import org.soltani.dao.AppUserRepository;
import org.soltani.entities.AppRole;
import org.soltani.entities.AppUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRolesRepository appRolesRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRolesRepository appRolesRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRolesRepository = appRolesRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String password, String confirmPassword) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) throw new RuntimeException("User already exists!");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Please confirm your password");
        AppUser user = new AppUser();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername(username);
        user.setActived(true);
        appUserRepository.save(user);
        addRoleToUser(username, "USER");
        return user;
    }

    @Override
    public AppRole saveRoles(AppRole role) {
        return appRolesRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRolesRepository.findByRoleName(role);
        appUser.getRoles().add(appRole);
    }
}
