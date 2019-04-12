package zut.cs.core.service;

import zut.cs.core.base.service.GenericTreeManager;
import zut.cs.core.domain.Connection;
import zut.cs.core.domain.Props;
import zut.cs.core.domain.TableMessage;

import java.util.List;

public interface TableMessageManager extends GenericTreeManager<TableMessage, Long> {
    TableMessage findByTableName(String TableName);

    List<Props> findAllprops(String TableName);

    Boolean updata(TableMessage tableMessage);

    List<Connection> findAllConnections(String TableName);
}
