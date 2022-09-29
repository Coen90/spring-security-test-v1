package com.cos.security1.config.auth;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security config 에서 loginProcessingUrl("/login")
 * /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는 loadUserByUsername 함수가 실행
 */
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // security session = Authentication = UserDetails

    /**
     * 시큐리티 session 내부 (Authentication(내부 UserDetails))
     * 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username = " + username);
        User userEntity = userRepository.findByUsername(username);
        System.out.println(userEntity.getUsername());
        System.out.println(userEntity.getEmail());
        System.out.println(userEntity.getRole());
        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        System.out.println("asdf");
        return null;
    }

}
