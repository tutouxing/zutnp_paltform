package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericTreeManagerImpl;
import zut.cs.core.dao.MenuDao;
import zut.cs.core.domain.Menu;
import zut.cs.core.service.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@Service
@Transactional
public class MenuManagerImpl extends GenericTreeManagerImpl<Menu,Long> implements MenuManager {
    MenuDao menuDao;
    @Autowired
    public void setMenuDao(MenuDao menuDao){
        this.menuDao=menuDao;
        this.treeDao=this.menuDao;
        this.dao=this.treeDao;
    }

    @Override
    public List<Menu> findAllMneus() {
        return menuDao.findMenusByParentIsNull();
    }
}
