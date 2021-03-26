package ru.skdvp.app.service;

import ru.skdvp.app.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    List<String>  getAllRolesNamesStringArray();

    void saveRole(Role role);

    void deleteRoleById(Long id);

    Role getRoleById(Long id);

    Role getByRoleName(String roleName);
}
