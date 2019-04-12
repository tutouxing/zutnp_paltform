package zut.cs.core.service.impl;

import zut.cs.core.base.service.impl.GenericTreeManagerImpl;
import zut.cs.core.dao.TableMessageDao;
import zut.cs.core.domain.Connection;
import zut.cs.core.domain.Props;
import zut.cs.core.domain.TableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zut.cs.core.service.TableMessageManager;

import java.util.List;

@Service
public class TableMessageManagerImpl extends GenericTreeManagerImpl<TableMessage, Long> implements TableMessageManager {
    TableMessageDao tableMessageDao;

    @Autowired
    public void setTableMessage(TableMessageDao tableMessageDao) {
        this.tableMessageDao = tableMessageDao;
        this.treeDao = this.tableMessageDao;
        this.dao = this.treeDao;
    }

    @Override
    public TableMessage findByTableName(String TableName) {
        return  this.tableMessageDao.findByTableName(TableName);
    }

    @Override
    public List<Props> findAllprops(String TableName) {
        TableMessage tableMessage=this.tableMessageDao.findByTableName(TableName);
        List<Props> propsList=tableMessage.getProps();
        return propsList;
    }

    @Override
    public List<Connection> findAllConnections(String TableName) {
        TableMessage tableMessage=this.tableMessageDao.findByTableName(TableName);
        List<Connection> connectionList=tableMessage.getConnections();
        return connectionList;
    }

    @Override
    public Boolean updata(TableMessage tableMessage) {
        this.tableMessageDao.save(tableMessage);
        return true;
    }
}
