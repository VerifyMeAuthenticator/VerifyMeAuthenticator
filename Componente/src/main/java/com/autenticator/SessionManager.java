package com.autenticator;

import com.autenticator.Users.User;

/**
 * Interface para gerenciamento de sessões.
 */
public interface SessionManager {
    void setAuthenticatedUser(User user);
    User getAuthenticatedUser();
    void clear();
}