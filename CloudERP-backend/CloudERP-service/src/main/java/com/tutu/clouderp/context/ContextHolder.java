package com.tutu.clouderp.context;

public class ContextHolder {
	private static ThreadLocal<Context> contextThreadLocal = new ThreadLocal<Context>();
	public static void setContext(Context context){
		contextThreadLocal.set(context);
	}
	
	public static Context getContext(){
		return contextThreadLocal.get();
	}
	
}
