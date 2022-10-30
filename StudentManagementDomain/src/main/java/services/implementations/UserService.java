package services.implementations;

import entities.implementations.Teacher;
import entities.implementations.User;
import repositories.implementations.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User createUser(String name, String password, String userType) {
        User user = new User(name, password, userType);
        return this.addUser(user);
    }

    public User addUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    public Optional<User> get(String username) {
        return this.userRepository.get(username);
    }
}
