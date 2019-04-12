package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericTreeDao;
import zut.cs.core.domain.Group;

import java.util.List;

public interface GroupDao extends GenericTreeDao<Group,Long> {
    List<Group> findGroupsByParentIsNull();
}
