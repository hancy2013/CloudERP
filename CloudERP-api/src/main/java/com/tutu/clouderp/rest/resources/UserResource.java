package com.tutu.clouderp.rest.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutu.clouderp.Entity.TokenTransfer;
import com.tutu.clouderp.Entity.User;
import com.tutu.clouderp.Entity.UserTransfer;
import com.tutu.clouderp.repository.UserRepository;
import com.tutu.clouderp.session.Hex;
import com.tutu.clouderp.session.SessionHolder;
import com.tutu.clouderp.session.TokenUtils;


@Component
@Path("/user")
public class UserResource
{

	@Autowired
	private UserRepository userRepository;

	/**
	 * Retrieves the currently logged in user.
	 * 
	 * @return A transfer containing the username and the roles.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserTransfer getUser()
	{
		User user=SessionHolder.getSession();
		if(user==null) return null;
		return new UserTransfer(user.getName(), createRoleMap(user));
	}


	/**
	 * Authenticates a user and creates an authentication token.
	 * 
	 * @param username
	 *            The name of the user.
	 * @param password
	 *            The password of the user.
	 * @return A transfer containing the authentication token.
	 */
	@Path("authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@FormParam("username") String username, @FormParam("password") String password)
	{
		
		User user = userRepository.findByName(username);
        if (user == null || !user.getPassword().equals(new String(Hex.encode(password.getBytes())))) {
        	throw new WebApplicationException(401);
        }
        return new TokenTransfer(TokenUtils.createToken(user));
	}


	private Map<String, Boolean> createRoleMap(User user)
	{
		Map<String, Boolean> roles = new HashMap<String, Boolean>();
		for (String role : user.getRoles()) {
			roles.put(role, Boolean.TRUE);
		}
		return roles;
	}

}