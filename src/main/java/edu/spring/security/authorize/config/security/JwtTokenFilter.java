package edu.spring.security.authorize.config.security;

import edu.spring.security.authorize.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpHeaders;

import static sun.util.locale.LocaleUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(isEmpty(header) || !header.startsWith("Bearer ")){
            chain.doFilter(request,response);
            return;
        }

        //Get jwt token and validate
        final String token = header.split("")[1].trim();
        if(!jwtTokenUtil.validate(token)){
            chain.doFilter(request, response);
            return;
        }

        //Get user identity and set it on the spring security context
        UserDetails userDetails = userRepository
                .findByUserName(jwtTokenUtil.g)
    }
}
