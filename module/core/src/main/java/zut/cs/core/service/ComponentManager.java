package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Component;
import zut.cs.core.domain.User;

import java.util.List;
import java.util.Set;

public interface ComponentManager extends GenericManager<Component, Long> {
    Set<Component> findByUser(User user);
}
