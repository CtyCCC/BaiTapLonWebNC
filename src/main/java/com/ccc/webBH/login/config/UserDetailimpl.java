package com.ccc.webBH.login.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ccc.webBH.login.dao.AccountDAO;
import com.ccc.webBH.login.dao.RoleDAO;
import com.ccc.webBH.management.entiy.Account;




@Service
public class UserDetailimpl  implements UserDetailsService{
	
	@Autowired
	AccountDAO accountdao;
	
	
	@Autowired
	RoleDAO roledao;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc =accountdao.getInfoAccbyName(username);
		if(acc == null )
		{
			 throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		String role = roledao.getRolebyCode(acc.getCode());
		List<GrantedAuthority> listrole =new ArrayList<GrantedAuthority>();
		listrole.add(new SimpleGrantedAuthority(role));
		return new User(username,acc.getPass(), listrole);
	}
	

}
