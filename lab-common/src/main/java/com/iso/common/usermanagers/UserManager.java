package com.iso.common.usermanagers;

public interface UserManager {
    Long authenticate(AuthCredentials auth);
    Long register(AuthCredentials auth);
    String getUsernameById(long userId);
}
