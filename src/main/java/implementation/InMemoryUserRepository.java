package implementation;

import java.util.HashMap;
import java.util.Map;

import entities.User;
import repository.UserRepository;

public class InMemoryUserRepository implements UserRepository {
	private Map<String, User> users = new HashMap<String, User>();

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
