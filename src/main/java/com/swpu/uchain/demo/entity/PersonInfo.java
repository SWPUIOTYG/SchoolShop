package com.swpu.uchain.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class PersonInfo implements Serializable, UserDetails {
    private Integer userId;

    private String name;

    private String profileImg;

    private String email;

    private String gender;

    private Date createTime;

    private Date lastEditTime;

    private String password;

    private String role;


    /**
     *数据库中的类型 int
     */
    private boolean accountnonexpired;

    private boolean accountnonlocked;

    private boolean credentialsnonexpired;

    private boolean enabled;

    private static final long serialVersionUID = 1L;


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountnonexpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountnonlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsnonexpired;
    }

    public PersonInfo(String name,String password,String role,boolean accountnonexpired,boolean accountnonlocked,boolean credentialsnonexpired,boolean enabled){
        this.name=name;
        this.password=password;
        this.role=role;
        this.accountnonexpired=accountnonexpired;
        this.accountnonlocked=accountnonlocked;
        this.credentialsnonexpired=credentialsnonexpired;
        this.enabled=enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }

}