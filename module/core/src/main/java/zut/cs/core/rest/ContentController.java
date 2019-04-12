package zut.cs.core.rest;

import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zut.cs.core.service.ContentManager;
/*
    Authod：dd
*/

@Controller
@RequestMapping("/Content")
public class ContentController extends GenericController<Content, Long, ContentManager> {
    ContentManager contentManager;

    @Autowired
    public void setContentManager(ContentManager contentManager) {
        this.contentManager = contentManager;
        this.manager = this.contentManager;
    }

}

