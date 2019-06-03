package zut.cs.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.ContentDao;
import zut.cs.core.domain.Content;
import zut.cs.core.service.ContentManager;

import java.util.List;


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

    @Cacheable(value = "content")
    @Override
    public List<Content> findByTitle(String title) {
        return contentDao.findTitleLike(title);
    }

    @Override
    public List<Content> findAll(long userId,long channelId) {
        return contentDao.findAllByUser_IdAndChannel_Id(userId,channelId);
    }
}