package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    void saveUser(User user);
    void deleteUser(Long Id);
    void updateUser(User user);
    User getUser(Long id);
}
