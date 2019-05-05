package com.ccc.webBH.login.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.ccc.webBH.login.dao.AccountDAO;



@Service
public class UserDetailimpl  implements UserDetailsService{

//	@Autowired
//	AccountDAO accountdao;
//	
//	@Autowired
//	RoleDAO roledao;
//	
	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
//		Account acc =null;
//		try {
//			acc = accountdao.getInfoAccbyName(username);
//			System.out.println(acc);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		if(acc == null) {
//			throw new UsernameNotFoundException("khong co tai khoan nay");
//		}
		//BCryptPasswordEncoder bcry =new BCryptPasswordEncoder();
		List<GrantedAuthority> listrole =new ArrayList<GrantedAuthority>();
		listrole.add(new SimpleGrantedAuthority("ROLE_CUSTOMMER"));
		return new User(username,"1", listrole);
	}

}
