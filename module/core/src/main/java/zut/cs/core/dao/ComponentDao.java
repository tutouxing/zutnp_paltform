package zut.cs.core.dao;

import org.springframework.data.jpa.repository.Query;
import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Component;
import zut.cs.core.domain.User;

import java.util.List;

public interface ComponentDao extends GenericDao<Component,Long> {
    List<Component> findByUser(User user);
}
