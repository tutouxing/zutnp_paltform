package zut.cs.core.rest;

import zut.cs.core.base.rest.GenericTreeController;
import zut.cs.core.domain.Group;
import zut.cs.core.domain.Menu;
import zut.cs.core.domain.User;
import zut.cs.core.service.MenuManager;
import zut.cs.core.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zut.cs.core.service.GroupManager;

import java.util.List;
import java.util.Set;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@RestController
@RequestMapping("group")
public class GroupController extends GenericTreeController<Group, Long, GroupManager> {
    GroupManager groupManager;
    @Autowired
    UserManager userManager;
    @Autowired
    MenuManager menuManager;

    @Autowired
    public void setGroupManager(GroupManager groupManager) {
        this.groupManager = groupManager;
        this.treeManager = this.groupManager;
        this.manager = this.treeManager;
    }

    @PostMapping("addUsers")
    public void addUser(@RequestParam String groupId, @RequestParam List<String> usersId) {
        if (usersId.size() > 0) {
            this.groupManager.addUsers(groupId, usersId);
        }
    }

    @GetMapping("getUsers")
    public Set<User> getUsers(@RequestParam String groupId) {
        return this.groupManager.getUsers(groupId);
    }

    @DeleteMapping("removeUsers")
    public void removeUsers(@RequestParam List<String> usersId) {
        this.groupManager.removeUsers(usersId);
    }

    @GetMapping("getMenus")
    public Set<Menu> getMenus(@RequestParam String groupId) {
        return this.groupManager.getMenus(groupId);
    }

    @PostMapping("addMenus")
    public void addMenus(@RequestParam String groupId, @RequestParam List<String> menusId) {
        this.groupManager.addMenus(groupId, menusId);
    }

    @PutMapping("updateMneus")
    public void updateMneus(@RequestParam String groupId, @RequestParam List<String> menusId) {
        this.groupManager.updateMenus(groupId, menusId);
    }

    @GetMapping("list")
    public List<Group> getList() {
        return groupManager.getAllGroup();
    }
}
