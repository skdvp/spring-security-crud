package ru.skdvp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skdvp.app.dao.UserDao;
import ru.skdvp.app.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    /*==========================CRUD=================================*/

    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    public User showUser(long id) {
        return userDao.showUser(id);
    }


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }
}
