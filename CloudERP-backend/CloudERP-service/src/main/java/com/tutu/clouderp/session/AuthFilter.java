package com.tutu.clouderp.session;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.tutu.clouderp.auth.dao.SystemDatastore;
import com.tutu.clouderp.context.Context;
import com.tutu.clouderp.context.ContextHolder;

public class AuthFilter implements ContainerRequestFilter {
	private static final SystemDatastore systemDatastore=(SystemDatastore)GlobalContext.getBean("systemDatastore");

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		ContextHolder.setContext(new Context());
		ContextHolder.getContext().setDatastore(systemDatastore);
//		String authToken = requestContext.getHeaderString("X-Auth-Token");
//		if (!requestContext.getUriInfo().getPath().endsWith("authenticate")) {
//			boolean paas = false;
//			if (authToken != null) {
//				String userName = TokenUtils.getUserNameFromToken(authToken);
//				if (userName != null) {
//					User user = systemDatastore.get(User.class, userName);
//					if (TokenUtils.validateToken(authToken, user)) {
//						Context context = new Context();
//						context.setUser(user);
//						ContextHolder.setContext(context);
//						paas = true;
//					}
//				}
//
//			}
//			if (!paas) {
//				requestContext.abortWith(Response.status(HttpServletResponse.SC_UNAUTHORIZED).entity("Unauthorized: Authentication token was either missing or invalid.").build());
//			}
//		}
	}

}
