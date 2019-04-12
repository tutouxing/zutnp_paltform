package zut.cs.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zut.cs.core.base.dao.GenericDao;
import zut.cs.core.domain.Connection;

@Repository
public interface ConnectionDao extends GenericDao<Connection, Long> {
    @Query("select o from Connection o  where o.connectionName=?1")
    public Connection findByConnection_name(@Param("connectionName") String connectionName);
}