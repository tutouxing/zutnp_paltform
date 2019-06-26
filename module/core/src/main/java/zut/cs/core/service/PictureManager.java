package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.Picture;

import java.util.List;

public interface PictureManager extends GenericManager<Picture, Long> {
    /**
     * @Description: java类作用描述

     * @Author: yc

     * @CreateDate: 2019/5/14$ 15:29$

     */
    Picture findByUrl(String url);
}
