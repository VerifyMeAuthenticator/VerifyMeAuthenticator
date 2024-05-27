package com.autenticator.Database;

import com.autenticator.User;

public interface UserDAO {

    // Salva um usuário no armazenamento de dados
    void saveUser(User user);

    // Localiza um usuário pelo nome de usuário
    User findByUsername(String username);
}