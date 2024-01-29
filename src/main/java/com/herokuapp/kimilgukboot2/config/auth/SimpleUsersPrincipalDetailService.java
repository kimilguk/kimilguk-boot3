package com.herokuapp.kimilgukboot2.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.herokuapp.kimilgukboot2.domain.simple_users.SimpleUsers;
import com.herokuapp.kimilgukboot2.domain.simple_users.SimpleUsersRepository;

// UserDetailsService 를 구현한 클래스
// 스프링 시큐리티가 로그인 요청을 가로챌 때, username, password 변수 2개를 가로채는데
// password 부분 처리는 알아서 함
@Service
public class SimpleUsersPrincipalDetailService implements UserDetailsService {
    // JPARepository 를 상속받은 인터페이스를 자동으로 DI (의존성 주입)
    @Autowired
    private SimpleUsersRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 넘겨받은 id 로 DB 에서 회원 정보를 찾음
    	SimpleUsers member = memberRepository.findByName(username);
        System.out.println("username : " + username);
        System.out.println("member : " + member);
        // 없을경우 에러 발생
        if(member == null)
            throw new UsernameNotFoundException(username + "을 찾을 수 없습니다.");
        if(member.getEnabled() != true)
            throw new UsernameNotFoundException("사용할 수 없는 계정입니다.");
        // PrincipalDetails 에 Member 객체를 넘겨줌
        return new SimpleUsersPrincipalDetails(member);
    }
}