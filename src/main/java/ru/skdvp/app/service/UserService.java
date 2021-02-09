package ru.skdvp.app.service;

import ru.skdvp.app.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String name);

    /*==========================CRUD=================================*/

    List<User> showAllUsers();

    User showUser(Long id);

    User saveUser(User user, Long idRole);

    void updateUser(Long id, User updateUser);

    void removeUserById(Long id);


}
