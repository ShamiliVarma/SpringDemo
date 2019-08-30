package org.arpit.java2blog.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.arpit.java2blog.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails{

	private User user;
	public MyUserPrincipal(User user){
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		grantedList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return grantedList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return (user.getEnabled()==1)? true : false;
	}

}
