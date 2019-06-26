package zut.cs.core.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Component;
import zut.cs.core.service.ComponentManager;

@RestController
@RequestMapping("component/")
@Api(tags = "组件接口")
public class ComponentController extends GenericController<Component, Long, ComponentManager> {
    ComponentManager componentManager;

    @Autowired
    public void setComponentManager(ComponentManager componentManager) {
        this.componentManager = componentManager;
        this.manager = this.componentManager;
    }
}
