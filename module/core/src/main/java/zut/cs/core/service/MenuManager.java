package zut.cs.core.service;

import zut.cs.core.base.service.GenericTreeManager;
import zut.cs.core.domain.Menu;

import java.util.List;

public interface MenuManager extends GenericTreeManager<Menu, Long> {
    //返回所有菜单（parent_id=null）
    List<Menu> findAllMneus();
}
