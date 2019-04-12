package zut.cs.core.rest;

import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zut.cs.core.service.UserManager;

import java.util.List;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User, Long, UserManager> {
    UserManager userManager;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
        this.manager = this.userManager;
    }

    @GetMapping("getByName")
    public User getUser(@RequestParam String username) {
        return this.userManager.findByUsername(username);
    }

    //设置用户页面
    @PostMapping("setPages")
    public void setPages(@RequestParam String userId,@RequestParam List<String> pages) {
        User user=userManager.findById(Long.valueOf(userId));
        user.setTheme(pages.get(0));
        user.setPage1(pages.get(1));
        user.setPage2(pages.get(2));
        userManager.save(user);
    }
}
