package zut.cs.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.ComponentDao;
import zut.cs.core.domain.Component;
import zut.cs.core.domain.User;
import zut.cs.core.service.ComponentManager;

import java.util.List;

@Service
public class ComponentManagerImpl extends GenericManagerImpl<Component, Long> implements ComponentManager {
    ComponentDao componentDao;

    @Autowired
    public void setComponentDao(ComponentDao componentDao) {
        this.componentDao = componentDao;
        this.dao = this.componentDao;
    }

    @Override
    public List<Component> findByUser(User user) {
        return componentDao.findByUser(user);
    }
}
