package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.UserDao;
import zut.cs.core.domain.User;
import zut.cs.core.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@Service
@Transactional
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager {
    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        this.dao = this.userDao;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
