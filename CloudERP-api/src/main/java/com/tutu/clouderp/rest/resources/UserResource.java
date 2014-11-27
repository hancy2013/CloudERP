package com.tutu.clouderp.rest.resources;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tutu.clouderp.Entity.TokenTransfer;
import com.tutu.clouderp.Entity.UserTransfer;
import com.tutu.clouderp.auth.dao.SystemDatastore;
import com.tutu.clouderp.auth.entity.User;
import com.tutu.clouderp.context.ContextHolder;
import com.tutu.clouderp.session.PwdUtils;
import com.tutu.clouderp.session.TokenUtils;


@Component
@Path("/user")
public class UserResource
{
	private static final Logger logger=LoggerFactory.getLogger(UserResource.class);
	@Resource
	private SystemDatastore systemDatastore;

	/**
	 * Retrieves the currently logged in user.
	 * 
	 * @return A transfer containing the username and the roles.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserTransfer getUser()
	{
		User user=ContextHolder.getContext().getUser();
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
		
		User user = systemDatastore.get(User.class,username);
        try {
			if (user == null || !user.getPassword().equals(PwdUtils.eccrypt(password))) {
				throw new WebApplicationException(401);
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("some thing wrong",e);
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