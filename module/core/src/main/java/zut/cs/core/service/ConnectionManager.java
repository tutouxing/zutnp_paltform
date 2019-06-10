package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Connection;

/*
    Authod：NoOne！

*/

public interface ConnectionManager extends GenericManager<Connection, Long> {
    Connection findByConnectionName(String ConnectionName);

    Boolean updata(Connection connection);
}