package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericTreeDao;
import zut.cs.core.domain.Menu;

import java.util.List;

public interface MenuDao extends GenericTreeDao<Menu,Long> {
    List<Menu> findMenusByParentIsNull();
}
