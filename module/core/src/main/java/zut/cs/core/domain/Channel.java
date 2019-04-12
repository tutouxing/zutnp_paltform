package zut.cs.core.domain;

import lombok.*;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Channel extends BaseEntity {
    private String enName;
    private String chName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
