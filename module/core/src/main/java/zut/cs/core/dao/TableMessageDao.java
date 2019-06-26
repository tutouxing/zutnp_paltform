package zut.cs.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zut.cs.core.base.dao.GenericTreeDao;
import zut.cs.core.domain.TableMessage;

@Repository
public interface TableMessageDao extends GenericTreeDao<TableMessage, Long> {

    @Query("select o from TableMessage o where o.tablename=?1")
    public TableMessage findByTableName(@Param("tablename") String tableName);
}
