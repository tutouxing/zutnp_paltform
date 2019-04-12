package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Group;
import zut.cs.core.domain.User;

import java.util.Set;

public interface UserDao extends GenericDao<User,Long> {
    User findByUsername(String username);
    Set<User> findByGroup(Group group);
}
