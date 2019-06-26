package zut.cs.core.rest;

import io.swagger.annotations.Api;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Element;
import zut.cs.core.service.ElementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@RestController
@RequestMapping("element")
@Api(tags = "元素接口，(没用)")
public class ElementController extends GenericController<Element, Long, ElementManager> {
    ElementManager elementManager;

    @Autowired
    public void setElementManager(ElementManager elementManager) {
        this.elementManager = elementManager;
        this.manager = this.elementManager;
    }
}
