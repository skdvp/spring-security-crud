package ru.skdvp.app.dao;

import ru.skdvp.app.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRoles();

    List<String> getAllRolesNamesStringArray();

    void saveRole(Role role);

    void deleteRoleById(Long id);

    Role getRoleById(Long id);

    Role getByRoleName(String roleName);
}
