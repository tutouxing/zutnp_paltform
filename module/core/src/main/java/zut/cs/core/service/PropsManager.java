package zut.cs.core.service;

import zut.cs.core.base.service.GenericManager;
import zut.cs.core.domain.Props;

public interface PropsManager extends GenericManager<Props, Long> {
    Props findByPropsName(String PropsName);

    Boolean updata(Props props);
}
