package org.arpit.java2blog.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthentication implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String user = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		boolean authSuccess = false;
		
		if((user.equals("DEEP") && password.equals("123456")) || (user.equals("MICKEY") && password.equals("123456"))) {
			authSuccess = true;
		}
		
		if(!authSuccess) {
			throw new BadCredentialsException("Incorrect Credentials!!");
		}
		
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		grantedList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user, password, grantedList);
		
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
