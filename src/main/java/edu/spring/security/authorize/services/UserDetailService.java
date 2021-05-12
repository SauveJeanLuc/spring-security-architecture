package edu.spring.security.authorize.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {

    UserDetails loadUSerByUsername(String username)
        throws UsernameNotFoundException;
}
