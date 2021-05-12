package edu.spring.security.authorize.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor @NoArgsConstructor @Data
public class Role implements GrantedAuthority {

    public static final String USER_ADMIN = "USER_ADMIN";
    public static final String AUTHOR_ADMIN = "AUTHOR_ADMIN";
    public static final String BOOK_ADMIN = "BOOK_ADMIN";

    private String authority;

}
