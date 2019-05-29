//package zut.cs.core.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import zut.cs.core.base.service.impl.GenericManagerImpl;
//import zut.cs.core.dao.ContentDao;
//import zut.cs.core.dao.PictureDao;
//import zut.cs.core.domain.Content;
//import zut.cs.core.domain.Picture;
//import zut.cs.core.service.PictureManager;
//
//import java.util.Set;
//
//@Service
//public class PictureManagerImpl extends GenericManagerImpl<Picture,Long> implements PictureManager {
//    /**
//     * @Description: java类作用描述
//
//     * @Author: wastelands
//
//     * @CreateDate: 2019/5/14$ 15:31$
//
//     */
//    PictureDao pictureDao;
//    @Autowired
//    public void setPictureDao(PictureDao pictureDao){
//        this.pictureDao = pictureDao;
//        this.dao = this.pictureDao;
//    }
//
//    @Override
//    public Set<Picture> findByContent(Content content) {
//
//        return pictureDao.findByContent(content);
//    }
//}
