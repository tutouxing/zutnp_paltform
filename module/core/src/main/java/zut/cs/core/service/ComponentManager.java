package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Component;
import zut.cs.core.domain.User;

import java.util.List;

public interface ComponentManager extends GenericManager<Component,Long> {
    List<Component> findByUser(User user);
}
