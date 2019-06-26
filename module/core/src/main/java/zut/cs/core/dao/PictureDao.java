package zut.cs.core.dao;

import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Picture;

public interface PictureDao extends GenericDao<Picture, Long> {
    Picture findByUrl(String url);

}