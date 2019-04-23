package zut.cs.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.core.base.rest.GenericController;
import zut.cs.core.domain.Component;
import zut.cs.core.service.ComponentManager;

@RestController
@RequestMapping("component/")
public class ComponentController extends GenericController<Component,Long,ComponentManager> {
    ComponentManager componentManager;
    @Autowired
    public void setComponentManager(ComponentManager componentManager){
        this.componentManager=componentManager;
        this.manager=this.componentManager;
    }
}
