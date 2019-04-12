package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Channel;
import zut.cs.core.domain.User;

import java.util.Set;

/*
    Authod：dd

*/

public interface ChannelManager extends GenericManager<Channel, Long> {
    Set<Channel> findUsers(User user);
}