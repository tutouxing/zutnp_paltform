package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.User;

public interface UserManager extends GenericManager<User,Long> {
    User findByUsername(String username);
}
