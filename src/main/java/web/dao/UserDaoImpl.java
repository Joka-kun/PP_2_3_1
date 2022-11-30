package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("select us from User us").getResultList();
    }
    @Override
    public User getUserById(int id) {
        return manager.find(User.class,id);
    }
    @Override
    public void saveUser(User user) {
        manager.persist(user);
    }
    @Override
    public void updateUser(int id, User updatedUser) {
        User user = manager.find(User.class,id);
        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
    }
    @Override
    public void deleteUser(int id) {
        manager.remove(getUserById(id));
    }
}
