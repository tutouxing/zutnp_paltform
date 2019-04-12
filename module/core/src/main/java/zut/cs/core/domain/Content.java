package zut.cs.core.domain;

import lombok.*;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Content extends BaseEntity {
    private String href;
    private String title;
    private String text;
    private String textHref;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
