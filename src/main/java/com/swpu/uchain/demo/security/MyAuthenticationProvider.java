package com.swpu.uchain.demo.security;

import com.swpu.uchain.demo.entity.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //从表单中获取用户名
        String username=authentication.getName();
        //从表单中获取密码
        String password= (String) authentication.getCredentials();

        PersonInfo personInfo= (PersonInfo) userDetailsService.loadUserByUsername(username);
        if(username ==null){
            throw new BadCredentialsException("用户名不存在");
        }

        if (!personInfo.getPassword().equals("123456")) {
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> authorities = personInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(personInfo, password, authorities);

    }




    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
