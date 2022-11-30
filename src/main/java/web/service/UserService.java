package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;
@Service
public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(int id);

    public void saveUser(User user);

    public void updateUser(int id, User updatedUser);

    public void deleteUser(int id);
}
