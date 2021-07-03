package com.zealot.dcasting.bo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zealot.dcasting.model.UmsPermission;
import com.zealot.dcasting.model.UmsUser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用戶詳情
 * Created by LeoLiu on 2020/6/7.
 */
public class CustomizedUserDetails implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UmsUser umsUser;
    private List<UmsPermission> permissionList;
    public CustomizedUserDetails(UmsUser umsUser, List<UmsPermission> permissionList) {
        this.umsUser = umsUser;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回當前用戶的角色
        return permissionList.stream()
                .map(permission ->new SimpleGrantedAuthority(permission.getId()+":"+permission.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsUser.getPassword();
    }

    @Override
    public String getUsername() {
        return umsUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return umsUser.getStatus() == 1 ? true : false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsUser.getStatus().equals(1);
    }
}
