package zut.cs.core.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zut.cs.core.domain.Component;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComponentDaoTest {
    @Autowired
    ComponentDao componentDao;
    @Test
    public void generate(){
        for (int i = 0; i < 10; i++) {
            Component component = new Component();
            component.setName("组件"+i);
            component.setModeId("样式"+i);
            componentDao.save(component);
        }
        Assert.assertEquals(10,componentDao.findAll().size());
    }
}