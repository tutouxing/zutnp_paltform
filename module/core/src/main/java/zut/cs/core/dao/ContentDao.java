package zut.cs.core.dao;

import org.springframework.data.jpa.repository.Query;
import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Channel;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.User;

import java.util.Set;

public interface ContentDao extends GenericDao<Content, Long> {
    @Query(value = "select c from Content c where c.title like %?1%")
    Set<Content> findTitleLike(String title);
    Set<Content> findAllByUser_IdAndChannel_Id(long userId, long channelId);
}
