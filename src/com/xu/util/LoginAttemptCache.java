package com.xu.util;

import java.util.HashMap;
import java.util.Map;

public class LoginAttemptCache {
    private static final Map<String, Integer> loginAttempts = new HashMap<>();
    public static final int MAX_ATTEMPTS = 3;

    public static int getLoginAttempts(String username) {
        return loginAttempts.getOrDefault(username, 0);
    }

    public static void setLoginAttempts(String username, int attempts) {
        loginAttempts.put(username, attempts);
    }

    public static void incrementLoginAttempts(String username) {
        loginAttempts.put(username, getLoginAttempts(username) + 1);
    }

    public static void resetLoginAttempts(String username) {
        loginAttempts.remove(username);
    }

    public static boolean isAccountLocked(String username) {
        return getLoginAttempts(username) >= MAX_ATTEMPTS;
    }
}
