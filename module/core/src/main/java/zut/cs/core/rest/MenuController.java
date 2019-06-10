package zut.cs.core.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zut.cs.core.base.rest.GenericTreeController;
import zut.cs.core.domain.Menu;
import zut.cs.core.service.ElementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.core.service.MenuManager;

import java.util.List;

@RestController
@RequestMapping("menu")
@Api(tags = "菜单接口")
public class MenuController extends GenericTreeController<Menu, Long, MenuManager> {
    @Autowired
    ElementManager elementManager;
    MenuManager menuManager;

    @Autowired
    public void setMenuManager(MenuManager menuManager) {
        this.menuManager = menuManager;
        this.treeManager = this.menuManager;
        this.manager = this.treeManager;
    }

    @ApiOperation(value = "得到所有菜单")
    @GetMapping("list")
    public List<Menu> getAll() {
        return menuManager.findAllMneus();
    }
}
