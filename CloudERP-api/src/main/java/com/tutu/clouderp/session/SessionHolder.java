package com.tutu.clouderp.session;

import com.tutu.clouderp.Entity.User;

public class SessionHolder {
    private static ThreadLocal<User> sessionThreadLocal = new ThreadLocal<User>() {

        @Override
        protected User initialValue() {
            return null;
        }

    };


    public static void remove() {
        sessionThreadLocal.remove();
    }


    public static void setSession(User user) {
        sessionThreadLocal.set(user);
    }


    public static User getSession() {
        return sessionThreadLocal.get();
    }
}
