package zut.cs.core.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import zut.cs.core.domain.Channel;
import zut.cs.core.domain.Component;
import zut.cs.core.domain.Group;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserInfo implements Serializable {
    private Group group;
    private Set<Channel> channel;
    private Set<Component> components;
}
