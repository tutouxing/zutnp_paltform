package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.User;

import java.util.Set;

/*
    Authod：dd

*/

public interface ContentManager extends GenericManager<Content, Long> {
    Set<Content> findByTitle(String title);
}