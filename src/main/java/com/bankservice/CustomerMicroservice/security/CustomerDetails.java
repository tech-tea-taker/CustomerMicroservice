package com.bankservice.CustomerMicroservice.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.bankservice.CustomerMicroservice.model.CustomerLoginModel;
import com.bankservice.CustomerMicroservice.model.CustomerModel;

@Component
public class CustomerDetails implements UserDetails{
	
	CustomerLoginModel model;
	
	

	public CustomerDetails(CustomerLoginModel model) {
		super();
		this.model = model;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3796151625373628614L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("Customer"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return model.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return model.getUserID();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
