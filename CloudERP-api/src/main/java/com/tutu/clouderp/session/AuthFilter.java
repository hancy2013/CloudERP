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

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tutu.clouderp.auth.dao.SystemDatastore;
import com.tutu.clouderp.auth.entity.User;
import com.tutu.clouderp.context.Context;
import com.tutu.clouderp.context.ContextHolder;

public class AuthFilter implements Filter {

	private SystemDatastore systemDatastore;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		systemDatastore = WebApplicationContextUtils.getWebApplicationContext(
				filterConfig.getServletContext()).getBean(SystemDatastore.class);

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String authToken = this.extractAuthTokenFromRequest(httpServletRequest);
		if(!httpServletRequest.getRequestURI().endsWith("authenticate")){
			boolean paas = false;
			if (authToken != null) {
				String userName = TokenUtils.getUserNameFromToken(authToken);
				if (userName != null) {
					User user = systemDatastore.get(User.class,userName);
					if (TokenUtils.validateToken(authToken, user)) {
						Context context=new Context();
						context.setUser(user);
						ContextHolder.setContext(context);
						paas = true;
					}
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
