package com.tutu.clouderp.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tutu.clouderp.Entity.User;
import com.tutu.clouderp.repository.UserRepository;

public class AuthFilter implements Filter {

	private UserRepository userRepository;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		userRepository = WebApplicationContextUtils.getWebApplicationContext(
				filterConfig.getServletContext()).getBean(UserRepository.class);

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		if (!httpServletRequest.getRequestURI().endsWith("authenticate")) {
			String authToken = this
					.extractAuthTokenFromRequest(httpServletRequest);
			String userName = TokenUtils.getUserNameFromToken(authToken);
			boolean paas = false;
			if (userName != null) {
				User user = userRepository.findByName(userName);
				if (TokenUtils.validateToken(authToken, user)) {
					SessionHolder.setSession(user);
					paas = true;
				}
			}
			if (!paas) {
				httpServletResponse
						.sendError(HttpServletResponse.SC_UNAUTHORIZED,
								"Unauthorized: Authentication token was either missing or invalid.");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
		String authToken = httpRequest.getHeader("X-Auth-Token");

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}
}
