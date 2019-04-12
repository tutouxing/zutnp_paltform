package zut.cs.core.service;

import zut.cs.core.base.service.GenericTreeManager;
import zut.cs.core.domain.Group;
import zut.cs.core.domain.Menu;
import zut.cs.core.domain.User;

import java.util.List;
import java.util.Set;

public interface GroupManager extends GenericTreeManager<Group,Long> {
    public void addUsers(String groupId, List<String> usersId);
    public Set<User> getUsers(String groupId);
    public void removeUsers(List<String> usersId);
    public void addMenus(String groupId, List<String> menusId);
    public Set<Menu> getMenus(String groupId);
    public void updateMenus(String grouId, List<String> menusId);
    public List<Group> getAllGroup();
}
