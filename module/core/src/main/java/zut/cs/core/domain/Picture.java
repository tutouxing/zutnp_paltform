package zut.cs.core.domain;

import lombok.Getter;
import lombok.Setter;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
public class Picture extends BaseEntity {
    private String url;
}