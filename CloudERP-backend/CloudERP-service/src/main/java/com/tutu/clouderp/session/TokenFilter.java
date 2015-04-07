package com.tutu.clouderp.session;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.tutu.clouderp.auth.dao.SystemDatastore;
import com.tutu.clouderp.context.Context;
import com.tutu.clouderp.context.ContextHolder;
import com.tutu.clouderp.dto.auth.User;

public class TokenFilter implements Filter{
	private SystemDatastore systemDatastore;

	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
		String authToken = httpRequest.getHeader("X-Auth-Token");

		/* If token not found get it from request parameter */
		if (authToken == null) {
			authToken = httpRequest.getParameter("token");
		}

		return authToken;
	}
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		if (RpcContext.getContext().getRequest(HttpServletRequest.class) != null) {
			HttpServletRequest httpServletRequest =RpcContext.getContext().getRequest(HttpServletRequest.class);
			HttpServletResponse httpServletResponse = RpcContext.getContext().getResponse(HttpServletResponse.class);
			System.out.println("Client address is " + httpServletRequest.getRemoteAddr());
			String authToken = this.extractAuthTokenFromRequest(httpServletRequest);
			if(!httpServletRequest.getRequestURI().endsWith("authenticate")){
				boolean paas = false;
				if (authToken != null) {
					String userName = TokenUtils.getUserNameFromToken(authToken);
					if (userName != null) {
						systemDatastore=(SystemDatastore)GlobalContext.getBean("systemDatastore");
						User user = systemDatastore.get(User.class,userName);
						if (TokenUtils.validateToken(authToken, user)) {
							Context context=new Context();
								try {
									context.setUser(user);
								} catch (UnknownHostException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							ContextHolder.setContext(context);
							paas = true;
						}
					}
					
				}
				if (!paas) {
						try {
							httpServletResponse
									.sendError(HttpServletResponse.SC_UNAUTHORIZED,
											"Unauthorized: Authentication token was either missing or invalid.");
							throw new RpcException("Unauthorized: Authentication token was either missing or invalid.");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}
		Result result = invoker.invoke(invocation);
		return result;
	}
}
