package zut.cs.core.rest;

//import edu.zut.cs.zutnlp.platform.dao.admin.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import zut.cs.core.domain.User;
import zut.cs.core.service.ChannelManager;
import zut.cs.core.service.UserManager;
import zut.cs.util.UpdateUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Set;

/*
    Authod：dd

*/
@RestController
@RequestMapping("/Channel")
@Api(tags = "栏目接口")
public class ChannelController extends GenericController<Channel, Long, ChannelManager> {
    ChannelManager channelManager;

    @Autowired
    UserManager userManager;

    @Autowired
    public void setChannelManager(ChannelManager channelManager) {
        this.channelManager = channelManager;
        this.manager = this.channelManager;
    }

    @ApiOperation(value = "通过用户ID添加栏目")
    @PostMapping("add/")
    public Channel addByUserId(@RequestBody Channel model, String userId) {
        model.setDateCreated(new Date());
        model.setUser(userManager.findById(Long.valueOf(userId)));
        channelManager.save(model);
        return model;
    }

    @ApiOperation(value = "更改栏目")
    @PutMapping("update/")
    public Channel update(@RequestBody Channel channel, String channelId, String userId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        channel.setDateModified(new Date());
        channel.setUser(userManager.findById(Long.valueOf(userId)));
        Channel channel1 = channelManager.findById(Long.valueOf(channelId));
        Channel channel2 = (Channel) UpdateUtil.get(channel, channel1);
        channel2.setId(Long.valueOf(channelId));
        channelManager.save(channel2);
        return channel2;
    }


    @GetMapping("userid")
    public Set<Channel> getChannelById(@RequestParam long id) {
        User user = new User();
        user.setId(id);
        return channelManager.findUsers(user);
    }
    @ApiOperation(value = "得到当前用户下的所有栏目")
    @GetMapping("/list")
    public Set<Channel> getAll(String userId){
        return channelManager.findUsers(userManager.findById(Long.valueOf(userId)));
    }
}

