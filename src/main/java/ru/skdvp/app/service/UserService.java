package ru.skdvp.app.service;

import ru.skdvp.app.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String name);

    /*==========================CRUD=================================*/

    List<User> showAllUsers();

    User showUser(Long id);

    void saveUser(User user, String[] role);

    void updateUser(Long id, User updateUser);

    void removeUserById(Long id);


}
