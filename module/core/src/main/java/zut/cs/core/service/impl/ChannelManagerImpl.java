package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.ChannelDao;
import zut.cs.core.domain.Channel;
import zut.cs.core.domain.User;
import zut.cs.core.service.ChannelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


/*
    Authod：dd

*/
@Service
class ChannelManagerImpl extends GenericManagerImpl<Channel, Long> implements ChannelManager {

    ChannelDao channelDao;

    @Autowired
    public void setChannelDao(ChannelDao channelDao) {
        this.channelDao = channelDao;
        this.dao = this.channelDao;
    }

    @Override
    public Set<Channel> findUsers(User user) {
        return channelDao.findByUser(user);
    }
}