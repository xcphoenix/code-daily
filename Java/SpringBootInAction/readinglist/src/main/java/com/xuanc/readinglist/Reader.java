package com.xuanc.readinglist;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

/**
 * ClassName    readinglist-Reader
 * Description  简单的 JPA 实体
 *
 * @author      xuanc
 * @date        19-5-27 下午3:20
 * @version     1.0
 */
@Entity
public class Reader implements UserDetails {

    /**
     * 序列化 UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Reader 字段
     */
    @Id
    private String username;
    private String fullname;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * UserDetails methods
     */

    /**
     * 授予 READER 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    /*
     * 不过期、不加锁、不禁用
     */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
