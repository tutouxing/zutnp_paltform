package zut.cs.core.domain;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class Picture extends BaseEntity {
    /**
     * @Description: java类作用描述
     * @Author: wastelands
     * @CreateDate: 2019/5/14$ 15:09$
     */
    private String url;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="content_id")
    Content content;
    private Long serial_number;

}