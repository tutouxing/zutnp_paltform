package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.User;

import java.util.Set;

public interface ContentDao extends GenericDao<Content, Long> {
    Set<Content> findByUser(User user);
}
