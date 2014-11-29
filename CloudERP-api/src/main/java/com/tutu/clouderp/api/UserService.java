package com.tutu.clouderp.api;

import org.springframework.stereotype.Service;

import com.tutu.clouderp.dto.TokenTransfer;
import com.tutu.clouderp.dto.UserTransfer;
@Service
public interface UserService {
	public UserTransfer getUser();
	public TokenTransfer authenticate(String username, String password);
}
