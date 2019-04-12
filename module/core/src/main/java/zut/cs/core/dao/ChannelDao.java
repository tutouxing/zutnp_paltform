package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Channel;
import zut.cs.core.domain.User;

import java.util.Set;

public interface ChannelDao extends GenericDao<Channel,Long> {
    Set<Channel> findByUser(User user);
}
