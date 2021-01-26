package ru.skdvp.app.service;

import ru.skdvp.app.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String name);

    /*==========================CRUD=================================*/

    List<User> showAllUsers();

    User showUser(long id);

    void saveUser(User user);

    void updateUser(long id, User updateUser);

    void removeUserById(long id);


}
