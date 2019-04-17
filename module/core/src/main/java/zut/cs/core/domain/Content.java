package zut.cs.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Content extends BaseEntity {
    private String href;
    private String title;
    private String text;
    private String textHref;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
