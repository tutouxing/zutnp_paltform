package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.ContentDao;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.User;
import zut.cs.core.service.ContentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


/*
    Authod：dd

*/
@Service
public class ContentManagerImpl extends GenericManagerImpl<Content, Long> implements ContentManager {

    ContentDao contentDao;

    @Autowired
    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
        this.dao = this.contentDao;
    }

    @Override
    public Set<Content> findByTitle(String title) {
        return contentDao.findTitleLike(title);
    }
}