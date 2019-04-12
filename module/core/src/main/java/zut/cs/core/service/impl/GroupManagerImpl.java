package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericTreeManagerImpl;
import zut.cs.core.dao.GroupDao;
import zut.cs.core.dao.MenuDao;
import zut.cs.core.dao.UserDao;
import zut.cs.core.domain.Group;
import zut.cs.core.domain.Menu;
import zut.cs.core.domain.User;
import zut.cs.core.service.GroupManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@Service
@Transactional
public class GroupManagerImpl extends GenericTreeManagerImpl<Group, Long> implements GroupManager {
    GroupDao groupDao;
    @Autowired
    UserDao userDao;
    @Autowired
    MenuDao menuDao;

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
        this.treeDao = this.groupDao;
        this.dao = this.treeDao;
    }

    /**
     * @para groupId
     * @para usersId
     * @description: 将usersId添加到group
     */
    public void addUsers(String groupId, List<String> usersId) {
        Group group = groupDao.getOne(Long.valueOf(groupId));
        for (String userId : usersId) {
            User user = userDao.getOne(Long.valueOf(userId));
            user.setGroup(group);
        }
    }

    /**
     * @para groupId
     * @description: 通过groupId查找其下所有用户
     */
    public Set<User> getUsers(String groupId) {
        Group group = groupDao.getOne(Long.valueOf(groupId));
        return userDao.findByGroup(group);
    }

    /**
     * @para groupId
     * @para usersId
     * @description: 移除该组下的users
     */
    @Override
    public void removeUsers(List<String> usersId) {
        for (String userId : usersId) {
            User user = userDao.getOne(Long.valueOf(userId));
            user.setGroup(null);
        }
    }

    @Override
    public void addMenus(String groupId, List<String> menusId) {
        Group group = groupDao.getOne(Long.valueOf(groupId));
        Set<Menu> menus = new HashSet<>();
        for (String menuId : menusId) {
            Menu menu = menuDao.getOne(Long.valueOf(menuId));
            menus.add(menu);
        }
        group.setMenus(menus);
    }

    @Override
    public Set<Menu> getMenus(String groupId) {
        Group group = groupDao.getOne(Long.valueOf(groupId));
        return group.getMenus();
    }

    @Override
    public void updateMenus(String grouId, List<String> menusId) {
        addMenus(grouId, menusId);
    }


    public List<Group> getAllGroup() {
        return groupDao.findGroupsByParentIsNull();
    }

}
