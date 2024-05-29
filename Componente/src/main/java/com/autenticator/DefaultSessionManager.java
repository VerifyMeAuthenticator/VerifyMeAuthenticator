package com.autenticator;

import com.autenticator.Users.User;


public class DefaultSessionManager implements SessionManager {

    private User authenticatedUser;

    @Override
    public void setAuthenticatedUser(User user) {
        this.authenticatedUser = user;
    }

    @Override
    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

    @Override
    public void clear() {
        authenticatedUser = null;
    }
}
