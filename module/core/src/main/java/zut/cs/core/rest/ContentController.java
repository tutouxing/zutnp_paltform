package zut.cs.core.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("/Content")
@Api(tags = "内容接口")
public class ContentController extends GenericController<Content, Long, ContentManager> {
    ContentManager contentManager;
    @Autowired
    ChannelManager channelManager;
    @Autowired
    UserManager userManager;
    @Autowired
    PictureManager pictureManager;

    @Autowired
    public void setContentManager(ContentManager contentManager) {
        this.contentManager = contentManager;
        this.manager = this.contentManager;
    }

    @PostMapping("add/")
    public Content addByChannelAndUser(@RequestBody Content content,String channelId,String userId){
        content.setDateCreated(new Date());
        content.setChannel(channelManager.findById(Long.valueOf(channelId)));
        content.setUser(userManager.findById(Long.valueOf(userId)));
        contentManager.save(content);
        return content;
    }
    @PutMapping("update/")
    public Content updateByChannelAndUserId(@RequestBody Content content,String contentId,String channelId,String userId){
        content.setDateModified(new Date());
        content.setId(Long.valueOf(contentId));
        content.setChannel(channelManager.findById(Long.valueOf(channelId)));
        content.setUser(userManager.findById(Long.valueOf(userId)));
        contentManager.save(content);
        return content;
    }
    @ApiOperation(value = ("通过标题查找内容(return 数组)"))
    @GetMapping("getByTitle/")
    public List<Content> getByTitle(String title){
        return contentManager.findByTitle(title);
    }
    @ApiOperation(value = "得到当前用户和栏目下的所有内容包括图片")
    @GetMapping("/list")
    public List<Content> getAll(long userId,long channelId){
        return contentManager.findAll(userId, channelId);
    }
}
