package com.autenticator.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.autenticator.Users.DefaultUser;
import com.autenticator.Users.User;

/**
 * Implementação da interface UserDAO que interage com um banco de dados.
 */
public class DatabaseUserDAO implements UserDAO {
    private Map<String, User> users = new HashMap<>();
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/autenticacao";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgre";

    /**
     * Construtor para inicializar a classe e carregar usuários do banco de dados.
     */
    public DatabaseUserDAO() {
        loadUsersFromDatabase();
    }

    /**
     * Carrega os usuários do banco de dados e armazena-os em um mapa.
     */
    private void loadUsersFromDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String role = rs.getString("role");
                users.put(username, new DefaultUser(username, password, role, email, phoneNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password, email, phone_number, role) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getRole());
            stmt.executeUpdate();
            users.put(user.getUsername(), user); // adiciona o novo usuário ao mapa
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/autenticacao", "postgres", "postgre")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String retrievedUsername = rs.getString("username");
                String retrievedPassword = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String role = rs.getString("role");
                User user = new DefaultUser(retrievedUsername, retrievedPassword, role, email, phoneNumber);
                
                // Adicione mensagens de log ou imprima o usuário recuperado
                System.out.println("Usuário recuperado: " + user.getUsername() + ", Papel: " + user.getRole());
                
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
