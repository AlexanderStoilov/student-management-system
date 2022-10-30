package com.auth.dao;

import com.auth.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import services.implementations.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("ApplicationUserDaoService")
public class ApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = new UserService();
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return userService.getAll().stream().map(ApplicationUser::new).collect(Collectors.toList());
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
