package zut.cs.core.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import zut.cs.core.service.ChannelManager;
import zut.cs.core.service.UserManager;

import java.util.Date;

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
    public Channel update(@RequestBody Channel channel, String channelId, String userId) {
        channel.setDateModified(new Date());
        channel.setId(Long.valueOf(channelId));
        channel.setUser(userManager.findById(Long.valueOf(userId)));
        channelManager.save(channel);
        return channel;
    }
}

