package com.herokuapp.kimilgukboot2.config.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.herokuapp.kimilgukboot2.domain.simple_users.SimpleUsers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


// Spring Security 에 있는 UserDetails 를 구현한 클래스,
// 이 클래스를 통해 Spring Security 에서 사용자의 정보를 담아둠
public class SimpleUsersPrincipalDetails implements UserDetails {
    // 패키지에 선언해놓은 엔티티를 사용하기 위해 선언
    private final SimpleUsers member;

    public SimpleUsersPrincipalDetails(SimpleUsers member) {
        this.member = member;
    }
    // 생성자
    public SimpleUsers getMember() {
        return member;
    }
    // 계정의 권한을 담아두기위해
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();//현재 테이블에 저장될 때 ADMIN, USER로 저장되기 때문에 생략된 부분 추가(아래)
        authorities.add(new SimpleGrantedAuthority("ROLE_" + member.getRole()));
        return authorities;
    }
    // 계정의 비밀번호를 담아두기 위해
    @Override
    public String getPassword() {
        return member.getPassword();
    }
    // 계정의 아이디를 담아두기 위해
    @Override
    public String getUsername() {
        return member.getUsername();
    }
    // 계정이 만료되지 않았는지를 담아두기 위해 (true: 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 계정이 잠겨있지 않았는지를 담아두기 위해 (true: 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정의 비밀번호가 만료되지 않았는지를 담아두기 위해 (true: 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화되어있는지를 담아두기 위해 (true: 활성화됨)
    @Override
    public boolean isEnabled() {
        return true;
    }
}