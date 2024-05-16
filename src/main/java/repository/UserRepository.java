package repository;

import entities.User;

public interface UserRepository {
	void addUser(User user);
    User getUser(String username);
}
