package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Content;

import java.util.List;

/*
    Authod：dd

*/

public interface ContentManager extends GenericManager<Content, Long> {
    List<Content> findByTitle(String title);

    List<Content> findAll(Long userId, Long channelId);

    Content addByChannelAndUser(Content content, String channelId, String userId);


}