package zut.cs.core.rest;

import zut.cs.core.domain.Channel;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.Group;
import zut.cs.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.core.service.ChannelManager;
import zut.cs.core.service.ContentManager;
import zut.cs.core.service.GroupManager;
import zut.cs.core.service.UserManager;

import java.util.Set;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@RestController
public class LoginController {
    @Autowired
    UserManager userManager;
    @Autowired
    GroupManager groupManager;
    @Autowired
    ChannelManager channelManager;

    @PostMapping("/login")
    public UserInfo login(@RequestBody User user) {
        UserInfo userInfo = new UserInfo();
        User user1 = userManager.findByUsername(user.getUsername());
        if (user.getPassword().equals(user1.getPassword())) {
            //如果用户未分配组，进行分配至基础组(基本权限)
            if (user1.getGroup() == null) {
                Set<Channel> channels = channelManager.findUsers(user1);
                Group group = groupManager.findById(Long.valueOf(5));
                user1.setGroup(group);
                userManager.save(user1);
                group.setTheme(user1.getTheme());
                group.setPage1(user1.getPage1());
                group.setPage2(user1.getPage2());
                group.setUserId(String.valueOf(user1.getId()));
                groupManager.save(group);
                userInfo.setGroup(group);
                userInfo.setChannel(channels);
                return userInfo;
            } else {
                Set<Channel> channels = channelManager.findUsers(user1);
                Group group = user1.getGroup();
                group.setTheme(user1.getTheme());
                group.setPage1(user1.getPage1());
                group.setPage2(user1.getPage2());
                group.setUserId(String.valueOf(user1.getId()));
                groupManager.save(group);
                userInfo.setGroup(group);
                userInfo.setChannel(channels);
                return userInfo;
            }
        }
        return null;
    }
}
