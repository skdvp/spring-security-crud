package ru.skdvp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skdvp.app.dao.UserDao;
import ru.skdvp.app.model.Role;
import ru.skdvp.app.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    /*==========================CRUD=================================*/

    @Transactional
    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Transactional
    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Transactional
    @Override
    public User saveUser(User user, Long idRole) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleService.getRoleById(idRole));
        user.setRoles(roleSet);
        userDao.saveUser(user);
        return user;
    }

    @Transactional
    @Override
    public void updateUser(Long id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }

    @Transactional
    @Override
    public void removeUserById(Long id) {
        userDao.removeUserById(id);
    }
}
