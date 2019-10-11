package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Component;
import zut.cs.core.domain.User;

import java.util.List;
import java.util.Set;

public interface ComponentDao extends GenericDao<Component, Long> {
    Set<Component> findByUser(User user);
}
