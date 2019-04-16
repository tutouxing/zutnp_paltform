package zut.cs.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Channel extends BaseEntity {
    private String enName;
    private String chName;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @OneToMany(mappedBy = "channel", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Content> contents;
}
