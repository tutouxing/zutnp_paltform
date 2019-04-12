package zut.cs.core.rest;

import zut.cs.core.domain.Channel;
import zut.cs.core.domain.Content;
import zut.cs.core.domain.Group;

import java.util.Set;

public class UserInfo {
    private Group group;
    private Set<Channel> channel;
    private Set<Content> content;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Channel> getChannel() {
        return channel;
    }

    public void setChannel(Set<Channel> channel) {
        this.channel = channel;
    }

    public Set<Content> getContent() {
        return content;
    }

    public void setContent(Set<Content> content) {
        this.content = content;
    }
}
