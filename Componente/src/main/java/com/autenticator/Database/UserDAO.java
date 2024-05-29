package com.autenticator.Database;

import java.util.Optional;

import com.autenticator.Users.User;
/**
 * Interface para operações de persistência de usuários.
 */
public interface UserDAO {
	/**
     * Salva um usuário no repositório.
     *
     * @param user o usuário a ser salvo
     */
    void saveUser(User user);
    Optional<User> findByUsername(String username);
}