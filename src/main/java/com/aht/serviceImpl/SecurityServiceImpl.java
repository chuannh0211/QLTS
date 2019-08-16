package com.aht.serviceImpl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.aht.service.SecurityService;

public class SecurityServiceImpl implements SecurityService {
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Override
	public String findLoggedInUsername() {
		// TODO Auto-generated method stub
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}
		return null;
	}

	@Override
	public void autoLogin(String username, String password) {
		// TODO Auto-generated method stub

	}

}
