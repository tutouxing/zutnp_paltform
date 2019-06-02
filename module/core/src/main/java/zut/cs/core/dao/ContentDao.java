package zut.cs.core.dao;

import org.springframework.data.jpa.repository.Query;
import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Content;

import java.util.List;

public interface ContentDao extends GenericDao<Content, Long> {
    @Query(value = "select c from Content c where c.title like %?1%")
    List<Content> findTitleLike(String title);
    List<Content> findAllByUser_IdAndChannel_Id(long userId, long channelId);
}
