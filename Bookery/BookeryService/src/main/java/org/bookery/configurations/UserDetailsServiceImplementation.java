package org.bookery.configurations;

import org.bookery.models.Credential;
import org.bookery.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImplementation implements UserDetailsService 
{

	@Autowired
	CredentialsRepository credentialRepository;
	
	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		Credential credentialModel = credentialRepository.findByLogin(loginName)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + loginName ));
		return new User(credentialModel.getLogin(), credentialModel.getPassword(), true, true, true, true, credentialModel.getAuthorities());
	}

}
