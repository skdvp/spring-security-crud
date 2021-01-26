package ru.skdvp.app.dao;

import ru.skdvp.app.model.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String name);

    /*==========================CRUD=================================*/

    List<User> showAllUsers();

    User showUser(long id);


    void saveUser(User user);

    void updateUser(long id, User updateUser);

    void removeUserById(long id);

}
