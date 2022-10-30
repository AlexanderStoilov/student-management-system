package com.auth.dao;

import com.auth.user.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}