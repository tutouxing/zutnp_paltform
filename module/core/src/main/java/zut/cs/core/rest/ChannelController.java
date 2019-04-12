package zut.cs.core.rest;

import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.core.service.ChannelManager;

/*
    Authod：dd

*/
@RestController
@RequestMapping("/Channel")
public class ChannelController extends GenericController<Channel, Long, ChannelManager> {
    ChannelManager channelManager;

    @Autowired
    public void setChannelManager(ChannelManager channelManager) {
        this.channelManager = channelManager;
        this.manager = this.channelManager;
    }
}

