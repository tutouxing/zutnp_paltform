package zut.cs.core.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.Picture;
import zut.cs.core.service.ContentManager;
import zut.cs.core.service.PictureManager;

import java.util.Set;

@RestController
@RequestMapping("/picture")
@Api("图片接口")
public class PictureController extends GenericController<Picture,Long, PictureManager> {
    /**
     * @Description: java类作用描述

     * @Author: wastelands

     * @CreateDate: 2019/5/14$ 15:26$

     */
    PictureManager pictureManager;

    @Autowired
    ContentManager contentManager;

    @Autowired
    public void setPictureManager(PictureManager pictureManager){
        this.pictureManager = pictureManager;
        this.manager = this.pictureManager;
    }

    @ApiOperation(value = "得到与内容相关的所有图片")
    @PostMapping("content_id/")
    public Set<Picture> getPicturesByContent(@RequestBody Content content){
        return pictureManager.findByContent(content.getId());
    }

}
