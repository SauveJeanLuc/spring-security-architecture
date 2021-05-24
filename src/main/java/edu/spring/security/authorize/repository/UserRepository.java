package edu.spring.security.authorize.repository;

import edu.spring.security.authorize.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Long, User>{
    Optional<User> findByUserName(String name);
}
