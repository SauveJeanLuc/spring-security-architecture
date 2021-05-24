package edu.spring.security.authorize.config.security;

import edu.spring.security.authorize.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import java.util.logging.Logger;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    private final String jwtSecret = "zdtlD3JK56m6wTTgsNFhqzjqP";
    private final String jwtIssuer = "example.io";

    private final Logger logger;

    public String generateAccessToken(User user){
        return Jwts.builder()
                .setSubject(format("%s,%s", user.getId(), user.getUsername()))
    }


}
