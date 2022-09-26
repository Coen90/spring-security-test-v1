package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * select * from user where username = 1?
     * Jpa Query method 로 검색하면 더 자세히 알 수 있따!
     * @param username
     * @return
     */
    User findByUsername(String username);

}
