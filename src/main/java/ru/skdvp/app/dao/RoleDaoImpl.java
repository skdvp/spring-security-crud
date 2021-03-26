package ru.skdvp.app.dao;

import org.springframework.stereotype.Repository;
import ru.skdvp.app.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public List<String>  getAllRolesNamesStringArray() {
        List<String> roleList = entityManager.createQuery("select name from Role", String.class).getResultList();
        return  roleList;
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void deleteRoleById(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery(
                "select r from Role r where r.id = :id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Role getByRoleName(String roleName) {
        TypedQuery<Role> query = entityManager
                .createQuery("select r from Role r where r = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        return query.getSingleResult();
    }

}

