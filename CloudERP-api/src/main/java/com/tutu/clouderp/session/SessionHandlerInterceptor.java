package com.tutu.clouderp.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tutu.clouderp.Entity.User;
import com.tutu.clouderp.repository.UserRepository;

public class SessionHandlerInterceptor extends HandlerInterceptorAdapter  {

	@Autowired
	private UserRepository userRepository;
	
	public boolean preHandle(final HttpServletRequest request,
			final HttpServletResponse response, final Object handler)
			throws Exception {
		String authToken = this.extractAuthTokenFromRequest(request);
		String userName = TokenUtils.getUserNameFromToken(authToken);
		if (userName != null) {
			User user = this.userRepository.findByName(userName);
			if(TokenUtils.validateToken(authToken, user)){
				SessionHolder.setSession(user);
				return true;
			}else{
				return false;
			}
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Unauthorized");
			return false;
		}
	}
	
	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest)
	{
		/* Get token from header */
		String authToken = httpRequest.getHeader("X-Auth-Token");

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}
	
}