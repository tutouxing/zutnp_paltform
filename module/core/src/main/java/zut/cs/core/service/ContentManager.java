package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Content;

import java.util.List;

/*
    Authod：dd

*/

public interface ContentManager extends GenericManager<Content, Long> {
    List<Content> findByTitle(String title);
    List<Content> findAll(long userId,long channelId);
}