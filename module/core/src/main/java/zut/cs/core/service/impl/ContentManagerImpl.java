package zut.cs.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.ContentDao;
import zut.cs.core.domain.Comment;
import zut.cs.core.domain.Content;
import zut.cs.core.service.ChannelManager;
import zut.cs.core.service.ContentManager;
import zut.cs.core.service.PictureManager;
import zut.cs.core.service.UserManager;

import java.util.Date;
import java.util.List;
import java.util.Set;


/*
    Authod：dd

*/
@Service
//@CacheConfig(cacheNames = "content")
public class ContentManagerImpl extends GenericManagerImpl<Content, Long> implements ContentManager {

    ContentDao contentDao;

    @Autowired
    ChannelManager channelManager;
    @Autowired
    UserManager userManager;
    @Autowired
    PictureManager pictureManager;

    @Autowired
    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
        this.dao = this.contentDao;
    }

//    @Cacheable(key = "#title", value = "content")
    @Override
    public List<Content> findByTitle(String title) {
        return contentDao.findTitleLike(title);
    }


//    @Cacheable(key = "#userId.toString().concat(#channelId.toString())", value = "contents")
    @Override
    public List<Content> findAll(Long userId, Long channelId) {
        return contentDao.findAllByUser_IdAndChannel_Id(userId, channelId);
    }

//    @Caching(put = {@CachePut(value = "content",key = "#userId.concat(#channelId)")})
    @Override
    public Content addByChannelAndUser(Content content, String channelId, String userId) {
        content.setDateCreated(new Date());
        content.setChannel(channelManager.findById(Long.valueOf(channelId)));
        content.setUser(userManager.findById(Long.valueOf(userId)));
        contentDao.save(content);
        return content;
    }


    //    @CacheEvict(key = "#id", value = "content")
    @Override
    public void delete(Long id) {
        super.delete(id);
    }

}