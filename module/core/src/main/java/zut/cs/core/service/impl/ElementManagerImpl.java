package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericManagerImpl;
import zut.cs.core.dao.ElementDao;
import zut.cs.core.domain.Element;
import zut.cs.core.service.ElementManager;
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
public class ElementManagerImpl extends GenericManagerImpl<Element, Long> implements ElementManager {
    ElementDao elementDao;

    @Autowired
    public void setElementDao(ElementDao elementDao) {
        this.elementDao = elementDao;
        this.dao = this.elementDao;
    }

}
